/**
 *
 */
package com.icsp.integ.db.factory;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static com.icsp.integ.util.Constants.ONE_MINUTE;

import java.util.Collection;
import java.util.Properties;

import javax.management.ObjectName;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDataSource;
import org.apache.commons.pool2.SwallowedExceptionListener;
import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.log4j.Logger;

/**
 * @author Administrator
 *
 */
public class DBCPDataSourceFactory implements DataSourceFactory, SwallowedExceptionListener {

	// protected static final String DRIVER_PROPERTY_PREFIX = "driver.";
	protected static final String			JMX_DOMAIN_NAME					= "stc:Name=DataSources";
	protected static final String			JMX_NAME_PREFIX					= ",Type=";
	private static Logger					log								= Logger.getLogger(DBCPDataSourceFactory.class);
	protected boolean						blockWhenExhausted				= true;
	protected boolean						cacheState;
	protected Collection<String>			connectionInitSqls;
	protected DataSource					dataSource;
	protected boolean						defaultAutoCommit				= true;
	protected String						defaultCatalog;
	protected int							defaultQueryTimeout;
	protected boolean						defaultReadOnly;
	protected int							defaultTransactionIsolation;
	protected String						driverClass;
	// #################################################
	// ## ............... NOT USED ...................##
	// #################################################
	protected boolean						enableAutoCommitOnReturn;
	protected String						id;
	// #################################################
	// ## Attributes to initiate DB Drivers with JMXs ##
	// #################################################
	protected boolean						jmxEnabled						= true;
	protected boolean						lifo							= true;
	// ###############################################
	// ## Attributes to Abandoned connections ..... ##
	// ###############################################
	protected boolean						logAbandoned					= false;
	protected long							maxConnLifetimeMillis;
	// ###############################################
	// ## Attributes to enable test idle connection ##
	// ###############################################
	protected int							maxIdle							= 2;
	// #################################################
	// ## Attributes to Create new DB Connections ....##
	// #################################################
	protected int							maxTotal;
	protected long							maxWaitMillis					= ONE_MINUTE;
	// Note : If minEvictableIdleTimeMillis is positive, then
	// softMinEvictableIdleTimeMillis is ignored
	protected long							minEvictableIdleTimeMillis		= 0;
	protected int							minIdle							= 1;
	protected int							numTestsPerEvictionRun			= -1;
	protected String						password;
	protected boolean						poolStatements;
	protected boolean						removeAbandonedOnBorrow			= true;
	protected boolean						removeAbandonedOnMaintenance	= true;
	protected int							removeAbandonedTimeout			= 1;
	protected boolean						rollbackOnReturn;
	protected long							softMinEvictableIdleTimeMillis	= 5 * ONE_MINUTE;
	// ########## Initiated According to DB type #######
	protected SwallowedExceptionListener	swallowedExceptionListener;
	protected boolean						testOnBorrow					= true;
	protected boolean						testOnCreate					= true;
	protected boolean						testOnReturn					= true;
	protected boolean						testWhileIdle					= true;
	protected long							timeBetweenEvictionRunsMillis	= 5 * ONE_MINUTE;
	protected String						url;
	protected String						userName;
	protected boolean						useUsageTracking				= true;
	// #################################################
	// ## Attributes to enable connections validation ##
	// #################################################
	protected String						validationQuery;
	protected int							validationQueryTimeout			= 5;

	/**
	 *
	 */
	public DBCPDataSourceFactory() {

		super();
	}

	@Override
	public DataSource getDataSource() {

		return this.dataSource;
	}

	@Override
	public void onSwallowException(Exception e) {

		logException("on Swallow : ", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
	}

	@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
	@Override
	public void setProperties(Properties properties) {

		try {
			id = properties.getProperty("id");
			url = properties.getProperty("url");
			userName = properties.getProperty("username");
			password = properties.getProperty("password");
			maxTotal = Integer.valueOf(properties.getProperty("maxtotal"));
			maxIdle = Integer.valueOf(properties.getProperty("maxidle"));
			minIdle = Integer.valueOf(properties.getProperty("minidle"));
			log.debug("ID [" + id + "] connectURI [" + url + "] " + " driverClass [" + driverClass + "] " + " userName [" + userName + "] password [" + password + "]");
			Class.forName(driverClass);
			ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, userName, password);
			ObjectName objectName = new ObjectName(JMX_DOMAIN_NAME + JMX_NAME_PREFIX + id);
			PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, objectName);
			// Pool Connection Factory Attributes
			poolableConnectionFactory.setConnectionInitSql(connectionInitSqls);
			poolableConnectionFactory.setDefaultAutoCommit(defaultAutoCommit);
			poolableConnectionFactory.setDefaultCatalog(defaultCatalog);
			poolableConnectionFactory.setDefaultQueryTimeout(defaultQueryTimeout);
			poolableConnectionFactory.setDefaultReadOnly(defaultReadOnly);
			poolableConnectionFactory.setDefaultTransactionIsolation(defaultTransactionIsolation);
			poolableConnectionFactory.setEnableAutoCommitOnReturn(enableAutoCommitOnReturn);
			poolableConnectionFactory.setMaxConnLifetimeMillis(maxConnLifetimeMillis);
			poolableConnectionFactory.setPoolStatements(poolStatements);
			poolableConnectionFactory.setRollbackOnReturn(rollbackOnReturn);
			poolableConnectionFactory.setValidationQuery(validationQuery);
			poolableConnectionFactory.setValidationQueryTimeout(validationQueryTimeout);
			poolableConnectionFactory.setCacheState(cacheState);
			// Create CP configurations
			GenericObjectPoolConfig config = new GenericObjectPoolConfig();
			config.setJmxEnabled(jmxEnabled);
			config.setJmxNameBase(JMX_DOMAIN_NAME);
			config.setJmxNamePrefix(JMX_NAME_PREFIX + id);
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnectionFactory, config);
			// Abandoned Configurations
			AbandonedConfig abandonedConfig = new AbandonedConfig();
			abandonedConfig.setLogAbandoned(logAbandoned);
			abandonedConfig.setRemoveAbandonedOnBorrow(removeAbandonedOnBorrow);
			abandonedConfig.setRemoveAbandonedOnMaintenance(removeAbandonedOnMaintenance);
			abandonedConfig.setRemoveAbandonedTimeout(removeAbandonedTimeout);
			abandonedConfig.setUseUsageTracking(useUsageTracking);
			connectionPool.setAbandonedConfig(abandonedConfig);
			// Connection Pool Attributes
			connectionPool.setBlockWhenExhausted(blockWhenExhausted);
			connectionPool.setLifo(lifo);
			connectionPool.setMaxIdle(maxIdle);
			connectionPool.setMinIdle(minIdle);
			connectionPool.setMaxTotal(maxTotal);
			connectionPool.setMaxWaitMillis(maxWaitMillis);
			connectionPool.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
			connectionPool.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
			connectionPool.setNumTestsPerEvictionRun(numTestsPerEvictionRun);
			connectionPool.setSoftMinEvictableIdleTimeMillis(softMinEvictableIdleTimeMillis);
			connectionPool.setSwallowedExceptionListener(this);
			connectionPool.setTestOnBorrow(testOnBorrow);
			connectionPool.setTestOnCreate(testOnCreate);
			connectionPool.setTestOnReturn(testOnReturn);
			connectionPool.setTestWhileIdle(testWhileIdle);
			poolableConnectionFactory.setPool(connectionPool);
			PoolingDataSource<PoolableConnection> poolDataSource = new PoolingDataSource<>(connectionPool);
			this.dataSource = poolDataSource;
		} catch (Exception e) {
			logException("getDriverProperties", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
	}
}