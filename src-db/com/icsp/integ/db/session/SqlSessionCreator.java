/**
 *
 */
package com.icsp.integ.db.session;

import static com.icsp.integ.db.session.SqlSessionInitiator.getInstance;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static org.apache.ibatis.session.ExecutorType.REUSE;

import com.icsp.integ.exception.ServiceDatabaseException;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author Mostafa M.Shawky
 *
 */
public class SqlSessionCreator {

	private Configuration	configuration;
	private SqlSessionData	sessionData;

	/**
	 *
	 */
	public SqlSessionCreator() {

		super();
	}

	/**
	 *
	 * @param mapperInterface
	 * @return
	 */
	public boolean addMapper(Class<?> mapperInterface) {

		try {
			if (configuration.getMapperRegistry().hasMapper(mapperInterface)) {
				return false;
			}
			configuration.addMapper(mapperInterface);
		} catch (Exception e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			return false;
		}
		return true;
	}

	/**
	 * This method for close connection
	 *
	 * @param sqlSession
	 */
	public void closeConnection(SqlSession sqlSession) {

		try {
			if (sqlSession != null) {
				sqlSession.close();
			}
		} catch (Exception e) {
			logException("Error when close connection ", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
	}

	public Configuration getConfiguration() {

		return configuration;
	}

	public SqlSessionData getSessionData() {

		return sessionData;
	}

	/**
	 * This method for get Mapper which get database information
	 *
	 * @param mapper
	 * @param enviroment
	 * @throws ServiceExceptionFactory
	 */
	public SqlSession getSqlSession(String enviroment) throws Exception {

		return getSqlSession(enviroment, REUSE);
	}

	/**
	 * This method for get Mapper which get database information
	 *
	 * @param mapper
	 * @param enviroment
	 * @throws ServiceExceptionFactory
	 */
	public SqlSession getSqlSession(String enviroment, ExecutorType executorType) throws Exception {

		SqlSession sqlSession = null;
		try {
			this.sessionData = getInstance(enviroment);
			SqlSessionFactory sessionFactory = sessionData.getSessionFactory();
			this.configuration = sessionFactory.getConfiguration();
			sqlSession = sessionFactory.openSession(executorType, true);
		} catch (Exception e) {
			logException("Error in getSqlSession", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			throw new ServiceDatabaseException(e);
		}
		return sqlSession;
	}

	public void setConfiguration(Configuration configuration) {

		this.configuration = configuration;
	}

	public void setSessionData(SqlSessionData sessionData) {

		this.sessionData = sessionData;
	}
}