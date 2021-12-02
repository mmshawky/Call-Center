/**
 *
 */
package com.istnet.stc.integ.jmx.database;

import com.istnet.stc.integ.jmx.JmxInformation;

/**
 * @author Mostafa M.Shawky
 *
 */
public class DBInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private Boolean				accessToUnderlyingConnectionAllowed;
	private String				className;
	private Boolean				closed;
	private String				connectionProperties;
	private String				context;
	private Boolean				defaultAutoCommit;
	private String				defaultCatalog;
	private Boolean				defaultReadOnly;
	private Integer				defaultTransactionIsolation;
	private String				driverClassName;
	private String				host;
	private Integer				initialSize;
	private Boolean				logAbandoned;
	private Integer				loginTimeout;
	private Integer				maxActive;
	private Integer				maxIdle;
	private Integer				maxOpenPreparedStatements;
	private Long				maxWait;
	private String				mBeanclass;
	private Long				minEvictableIdleTimeMillis;
	private Integer				minIdle;
	private String				modelerType;
	private String				name;
	private Integer				numActive;
	private Integer				numIdle;
	private Integer				numTestsPerEvictionRun;
	private String				password;
	private Boolean				poolPreparedStatements;
	private Boolean				removeAbandoned;
	private Integer				removeAbandonedTimeout;
	private Boolean				testOnBorrow;
	private Boolean				testOnReturn;
	private Boolean				testWhileIdle;
	private Long				timeBetweenEvictionRunsMillis;
	private String				type;
	private String				url;
	private String				username;
	private String				validationQuery;
	private Integer				validationQueryTimeout;

	public DBInformation() {

		super();
	}

	/**
	 * @return the accessToUnderlyingConnectionAllowed
	 */
	public Boolean getAccessToUnderlyingConnectionAllowed() {

		return accessToUnderlyingConnectionAllowed;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {

		return className;
	}

	/**
	 * @return the closed
	 */
	public Boolean getClosed() {

		return closed;
	}

	/**
	 * @return the connectionProperties
	 */
	public String getConnectionProperties() {

		return connectionProperties;
	}

	/**
	 * @return the context
	 */
	public String getContext() {

		return context;
	}

	/**
	 * @return the defaultAutoCommit
	 */
	public Boolean getDefaultAutoCommit() {

		return defaultAutoCommit;
	}

	/**
	 * @return the defaultCatalog
	 */
	public String getDefaultCatalog() {

		return defaultCatalog;
	}

	/**
	 * @return the defaultReadOnly
	 */
	public Boolean getDefaultReadOnly() {

		return defaultReadOnly;
	}

	/**
	 * @return the defaultTransactionIsolation
	 */
	public Integer getDefaultTransactionIsolation() {

		return defaultTransactionIsolation;
	}

	/**
	 * @return the driverClassName
	 */
	public String getDriverClassName() {

		return driverClassName;
	}

	/**
	 * @return the host
	 */
	public String getHost() {

		return host;
	}

	/**
	 * @return the initialSize
	 */
	public Integer getInitialSize() {

		return initialSize;
	}

	/**
	 * @return the logAbandoned
	 */
	public Boolean getLogAbandoned() {

		return logAbandoned;
	}

	/**
	 * @return the loginTimeout
	 */
	public Integer getLoginTimeout() {

		return loginTimeout;
	}

	/**
	 * @return the maxActive
	 */
	public Integer getMaxActive() {

		return maxActive;
	}

	/**
	 * @return the maxIdle
	 */
	public Integer getMaxIdle() {

		return maxIdle;
	}

	/**
	 * @return the maxOpenPreparedStatements
	 */
	public Integer getMaxOpenPreparedStatements() {

		return maxOpenPreparedStatements;
	}

	/**
	 * @return the maxWait
	 */
	public Long getMaxWait() {

		return maxWait;
	}

	/**
	 * @return the mBeanclass
	 */
	public String getmBeanclass() {

		return mBeanclass;
	}

	/**
	 * @return the minEvictableIdleTimeMillis
	 */
	public Long getMinEvictableIdleTimeMillis() {

		return minEvictableIdleTimeMillis;
	}

	/**
	 * @return the minIdle
	 */
	public Integer getMinIdle() {

		return minIdle;
	}

	/**
	 * @return the modelerType
	 */
	public String getModelerType() {

		return modelerType;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @return the numActive
	 */
	public Integer getNumActive() {

		return numActive;
	}

	/**
	 * @return the numIdle
	 */
	public Integer getNumIdle() {

		return numIdle;
	}

	/**
	 * @return the numTestsPerEvictionRun
	 */
	public Integer getNumTestsPerEvictionRun() {

		return numTestsPerEvictionRun;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {

		return password;
	}

	/**
	 * @return the poolPreparedStatements
	 */
	public Boolean getPoolPreparedStatements() {

		return poolPreparedStatements;
	}

	/**
	 * @return the removeAbandoned
	 */
	public Boolean getRemoveAbandoned() {

		return removeAbandoned;
	}

	/**
	 * @return the removeAbandonedTimeout
	 */
	public Integer getRemoveAbandonedTimeout() {

		return removeAbandonedTimeout;
	}

	/**
	 * @return the testOnBorrow
	 */
	public Boolean getTestOnBorrow() {

		return testOnBorrow;
	}

	/**
	 * @return the testOnReturn
	 */
	public Boolean getTestOnReturn() {

		return testOnReturn;
	}

	/**
	 * @return the testWhileIdle
	 */
	public Boolean getTestWhileIdle() {

		return testWhileIdle;
	}

	/**
	 * @return the timeBetweenEvictionRunsMillis
	 */
	public Long getTimeBetweenEvictionRunsMillis() {

		return timeBetweenEvictionRunsMillis;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {

		return url;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {

		return username;
	}

	/**
	 * @return the validationQuery
	 */
	public String getValidationQuery() {

		return validationQuery;
	}

	/**
	 * @return the validationQueryTimeout
	 */
	public Integer getValidationQueryTimeout() {

		return validationQueryTimeout;
	}

	/**
	 * @param accessToUnderlyingConnectionAllowed
	 *            the accessToUnderlyingConnectionAllowed to set
	 */
	public void setAccessToUnderlyingConnectionAllowed(Boolean accessToUnderlyingConnectionAllowed) {

		this.accessToUnderlyingConnectionAllowed = accessToUnderlyingConnectionAllowed;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * @param closed
	 *            the closed to set
	 */
	public void setClosed(Boolean closed) {

		this.closed = closed;
	}

	/**
	 * @param connectionProperties
	 *            the connectionProperties to set
	 */
	public void setConnectionProperties(String connectionProperties) {

		this.connectionProperties = connectionProperties;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {

		this.context = context;
	}

	/**
	 * @param defaultAutoCommit
	 *            the defaultAutoCommit to set
	 */
	public void setDefaultAutoCommit(Boolean defaultAutoCommit) {

		this.defaultAutoCommit = defaultAutoCommit;
	}

	/**
	 * @param defaultCatalog
	 *            the defaultCatalog to set
	 */
	public void setDefaultCatalog(String defaultCatalog) {

		this.defaultCatalog = defaultCatalog;
	}

	/**
	 * @param defaultReadOnly
	 *            the defaultReadOnly to set
	 */
	public void setDefaultReadOnly(Boolean defaultReadOnly) {

		this.defaultReadOnly = defaultReadOnly;
	}

	/**
	 * @param defaultTransactionIsolation
	 *            the defaultTransactionIsolation to set
	 */
	public void setDefaultTransactionIsolation(Integer defaultTransactionIsolation) {

		this.defaultTransactionIsolation = defaultTransactionIsolation;
	}

	/**
	 * @param driverClassName
	 *            the driverClassName to set
	 */
	public void setDriverClassName(String driverClassName) {

		this.driverClassName = driverClassName;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {

		this.host = host;
	}

	/**
	 * @param initialSize
	 *            the initialSize to set
	 */
	public void setInitialSize(Integer initialSize) {

		this.initialSize = initialSize;
	}

	/**
	 * @param logAbandoned
	 *            the logAbandoned to set
	 */
	public void setLogAbandoned(Boolean logAbandoned) {

		this.logAbandoned = logAbandoned;
	}

	/**
	 * @param loginTimeout
	 *            the loginTimeout to set
	 */
	public void setLoginTimeout(Integer loginTimeout) {

		this.loginTimeout = loginTimeout;
	}

	/**
	 * @param maxActive
	 *            the maxActive to set
	 */
	public void setMaxActive(Integer maxActive) {

		this.maxActive = maxActive;
	}

	/**
	 * @param maxIdle
	 *            the maxIdle to set
	 */
	public void setMaxIdle(Integer maxIdle) {

		this.maxIdle = maxIdle;
	}

	/**
	 * @param maxOpenPreparedStatements
	 *            the maxOpenPreparedStatements to set
	 */
	public void setMaxOpenPreparedStatements(Integer maxOpenPreparedStatements) {

		this.maxOpenPreparedStatements = maxOpenPreparedStatements;
	}

	/**
	 * @param maxWait
	 *            the maxWait to set
	 */
	public void setMaxWait(Long maxWait) {

		this.maxWait = maxWait;
	}

	/**
	 * @param mBeanclass
	 *            the mBeanclass to set
	 */
	public void setmBeanclass(String mBeanclass) {

		this.mBeanclass = mBeanclass;
	}

	/**
	 * @param minEvictableIdleTimeMillis
	 *            the minEvictableIdleTimeMillis to set
	 */
	public void setMinEvictableIdleTimeMillis(Long minEvictableIdleTimeMillis) {

		this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
	}

	/**
	 * @param minIdle
	 *            the minIdle to set
	 */
	public void setMinIdle(Integer minIdle) {

		this.minIdle = minIdle;
	}

	/**
	 * @param modelerType
	 *            the modelerType to set
	 */
	public void setModelerType(String modelerType) {

		this.modelerType = modelerType;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @param numActive
	 *            the numActive to set
	 */
	public void setNumActive(Integer numActive) {

		this.numActive = numActive;
	}

	/**
	 * @param numIdle
	 *            the numIdle to set
	 */
	public void setNumIdle(Integer numIdle) {

		this.numIdle = numIdle;
	}

	/**
	 * @param numTestsPerEvictionRun
	 *            the numTestsPerEvictionRun to set
	 */
	public void setNumTestsPerEvictionRun(Integer numTestsPerEvictionRun) {

		this.numTestsPerEvictionRun = numTestsPerEvictionRun;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {

		this.password = password;
	}

	/**
	 * @param poolPreparedStatements
	 *            the poolPreparedStatements to set
	 */
	public void setPoolPreparedStatements(Boolean poolPreparedStatements) {

		this.poolPreparedStatements = poolPreparedStatements;
	}

	/**
	 * @param removeAbandoned
	 *            the removeAbandoned to set
	 */
	public void setRemoveAbandoned(Boolean removeAbandoned) {

		this.removeAbandoned = removeAbandoned;
	}

	/**
	 * @param removeAbandonedTimeout
	 *            the removeAbandonedTimeout to set
	 */
	public void setRemoveAbandonedTimeout(Integer removeAbandonedTimeout) {

		this.removeAbandonedTimeout = removeAbandonedTimeout;
	}

	/**
	 * @param testOnBorrow
	 *            the testOnBorrow to set
	 */
	public void setTestOnBorrow(Boolean testOnBorrow) {

		this.testOnBorrow = testOnBorrow;
	}

	/**
	 * @param testOnReturn
	 *            the testOnReturn to set
	 */
	public void setTestOnReturn(Boolean testOnReturn) {

		this.testOnReturn = testOnReturn;
	}

	/**
	 * @param testWhileIdle
	 *            the testWhileIdle to set
	 */
	public void setTestWhileIdle(Boolean testWhileIdle) {

		this.testWhileIdle = testWhileIdle;
	}

	/**
	 * @param timeBetweenEvictionRunsMillis
	 *            the timeBetweenEvictionRunsMillis to set
	 */
	public void setTimeBetweenEvictionRunsMillis(Long timeBetweenEvictionRunsMillis) {

		this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {

		this.url = url;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {

		this.username = username;
	}

	/**
	 * @param validationQuery
	 *            the validationQuery to set
	 */
	public void setValidationQuery(String validationQuery) {

		this.validationQuery = validationQuery;
	}

	/**
	 * @param validationQueryTimeout
	 *            the validationQueryTimeout to set
	 */
	public void setValidationQueryTimeout(Integer validationQueryTimeout) {

		this.validationQueryTimeout = validationQueryTimeout;
	}
}