/**
 *
 */
package com.icsp.integ.db.session;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.integ.exception.ServiceApplicationException;
import com.icsp.integ.exception.ServiceDatabaseException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * This Class initiate database connection from Mybitas Framework By create
 * singleton instance
 *
 * @author MSH
 * @version 1.0
 */
public class SqlSessionInitiator {

	private static ConcurrentHashMap<String, SqlSessionData>	concurrentHashMap	= new ConcurrentHashMap<String, SqlSessionData>();
	private static File											file;
	private static FileInputStream								fileInputStream;
	private static final Lock									lock				= new ReentrantLock();
	private static Logger										logger				= Logger.getLogger(SqlSessionInitiator.class);
	private final static String									RESOURCE_FILE		= "resources/config.xml";

	/**
	 *
	 * @param env
	 * @return
	 * @throws ServiceExceptionFactory
	 * @throws IOException
	 */
	static synchronized SqlSessionData getInstance(String env) throws ServiceApplicationException {

		// TODO: remove all LOCK implementation
		boolean locked = lock.tryLock();
		if (locked == false) {
			logger.info(" >>> " + env + " Came to method but found lock is " + locked);
		}
		if (locked) {
			try {
				if (file == null) {
					logger.info("Read file : " + RESOURCE_FILE);
					file = Resources.getResourceAsFile(RESOURCE_FILE);
				}
				if (file != null) {
					if (!concurrentHashMap.containsKey(env)) {
						fileInputStream = new FileInputStream(file);
						SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
						SqlSessionFactory sessionFactory = builder.build(fileInputStream, env);
						concurrentHashMap.put(env, new SqlSessionData(sessionFactory));
					}
				}
			} catch (IOException e) {
				file = null;
				throw new ServiceApplicationException("Error Reading Resource file : " + RESOURCE_FILE, e);
			} catch (Exception e) {
				file = null;
				logException("Error in SqlSessionFactory", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
				throw new ServiceDatabaseException(e);
			}
			finally {
				lock.unlock();
				try {
					if (fileInputStream != null) {
						fileInputStream.close();
					}
				} catch (IOException ex) {
					// Intentionally ignore
				}
			}
		}
		return concurrentHashMap.get(env);
	}

	/**
	 * This default constructor
	 */
	private SqlSessionInitiator() {

		super();
	}
}