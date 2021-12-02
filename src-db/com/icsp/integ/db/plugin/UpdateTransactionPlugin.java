/**
 *
 */
package com.icsp.integ.db.plugin;

import static com.icsp.integ.util.Common.getSingletonExecutorInstance;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.INSERT_THREAD_TIMEOUT;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static java.util.concurrent.TimeUnit.SECONDS;

import com.icsp.integ.exception.ServiceApplicationException;
import com.icsp.integ.exception.ServiceDatabaseException;
import com.icsp.integ.exception.ServiceRuntimeException;
import com.icsp.integ.exception.ServiceTimeoutException;
import com.icsp.ivr.agi.log.LogEntity;

import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
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

/**
 * @author MSH
 *
 */
@Intercepts ({ @Signature (type = Executor.class,method = "update",args = { MappedStatement.class, Object.class }) })
public class UpdateTransactionPlugin implements Interceptor {

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
	public UpdateTransactionPlugin() {

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
		Future<Object> future = null;
		try {
			try {
				// Start call database SQL
				ExecutorService executorService = getSingletonExecutorInstance();
				start = System.currentTimeMillis();
				future = executorService.submit(new QueryProcess(invocation));
				proceed = future.get(INSERT_THREAD_TIMEOUT, SECONDS);
				// Finished
			} catch (InterruptedException e) {
				throw new ServiceTimeoutException(e);
			} catch (ExecutionException e) {
				throw new ServiceDatabaseException(e);
			} catch (TimeoutException e) {
				throw new ServiceTimeoutException(e);
			} catch (Exception e) {
				throw new ServiceDatabaseException(e);
			}
		} catch (ServiceRuntimeException e) {
			e.printStackTrace();
			logException("Error in UPDATE [RuntimeException] Function", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			exception = e;
			throw e;
		} catch (Exception e) {
			logException("Error in UPDATE [Exception] Function", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			exception = new ServiceApplicationException(e);
			throw exception;
		}
		finally {
			if (future != null) {
				future.cancel(true);
			}
			if (exception != null) {
				new LogEntity(invocation, exception, System.currentTimeMillis() - start);
			}
		}
		return proceed;
	}

	@Override
	public Object plugin(Object target) {

		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

	}
}