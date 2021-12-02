/**
 *
 */
package com.icsp.integ.db.plugin;

import static com.icsp.integ.util.Common.getSingletonExecutorInstance;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.DETAILED_EXCEPTION_LINES;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static com.icsp.integ.util.Constants.SELECT_THREAD_TIMEOUT;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.icsp.integ.exception.ServiceApplicationException;
import com.icsp.integ.exception.ServiceDatabaseException;
import com.icsp.integ.exception.ServiceRuntimeException;
import com.icsp.integ.exception.ServiceTimeoutException;
import com.icsp.ivr.agi.log.LogEntity;

import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

/**
 * @author Mostafa M.Shawky
 *
 */
@Intercepts ({ @Signature (type = Executor.class,method = "query",args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class SelectTransactionPlugin implements Interceptor {

	/**
	 *
	 * @author Administrator
	 *
	 */
	class QueryProcess implements Callable<Object> {

		Invocation	invocation;

		public QueryProcess(Invocation invocation) {

			this.invocation = invocation;
		}

		@Override
		public Object call() throws Exception {

			return invocation.proceed();
		}
	}

	/**
	 *
	 */
	public SelectTransactionPlugin() {

		super();
	}

	/*
	 * @see
	 * org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin
	 * .Invocation)
	 */
	@Override
	public Object intercept(Invocation invocation) throws ServiceRuntimeException {

		Object proceed = null;
		long start = 0l;
		ServiceRuntimeException exception = null;
		try {
			start = System.currentTimeMillis();
			// Start call database SQL
			proceed = retryQuery(invocation);
			// Finished
		} catch (ServiceRuntimeException e) {
			exception = e;
			throw e;
		} catch (Exception e) {
			logException("Error in SELECT [Exception] Function", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC, DETAILED_EXCEPTION_LINES);
			exception = new ServiceApplicationException(e);
			throw exception;
		}
		finally {
			new LogEntity(invocation, exception, System.currentTimeMillis() - start);
		}
		return proceed;
	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);
	}

	/**
	 * This method for re-try calling query to avoid back-end delay
	 *
	 * @param invocation
	 * @param tries
	 * @return
	 */
	private Object retryQuery(Invocation invocation) throws ServiceRuntimeException {

		Future<Object> future = null;
		try {
			ExecutorService executorService = getSingletonExecutorInstance();
			future = executorService.submit(new QueryProcess(invocation));
			return future.get(SELECT_THREAD_TIMEOUT, SECONDS);
		} catch (InterruptedException | TimeoutException e) {
			throw new ServiceTimeoutException(e);
		} catch (Exception e) {
			if (future != null) {
				future.cancel(true);
			}
			throw new ServiceDatabaseException(e);
		}
	}

	@Override
	public void setProperties(Properties properties) {

	}
}