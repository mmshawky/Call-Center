package com.istnet.stc.integ.jmx.database;

import com.istnet.stc.integ.jmx.JmxInformation;

public class DBGFInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private String				allowNonComponentCallers;
	private String				associateWithThread;
	private String				averageconnwaittime;
	private String				connectionCreationRetryAttempts;
	private String				connectionCreationRetryIntervalInSeconds;
	private String				connectionLeakReclaim;
	private String				connectionLeakTimeoutInSeconds;
	private String				connectionValidationMethod;
	private String				connrequestwaittime;
	private String				datasourceClassname;
	private String				deploymentOrder;
	private String				description;
	private String				driverClassname;
	private String				failAllConnections;
	private String				idleTimeoutInSeconds;
	private String				initSql;
	private String				isConnectionValidationRequired;
	private String				isIsolationLevelGuaranteed;
	private String				lazyConnectionAssociation;
	private String				lazyConnectionEnlistment;
	private String				matchConnections;
	private String				maxConnectionUsageCount;
	private String				maxPoolSize;
	private String				maxWaitTimeInMillis;
	private String				name;
	private String				nonTransactionalConnections;
	private String				numconnacquired;
	private String				numconncreated;
	private String				numconndestroyed;
	private String				numconnfailedvalidation;
	private String				numconnfree;
	private String				numconnnotsuccessfullymatched;
	private String				numconnreleased;
	private String				numconnsuccessfullymatched;
	private String				numconntimedout;
	private String				numconnused;
	private String				numpotentialconnleak;
	private String				objectType;
	private String				ping;
	private String				pooling;
	private String				poolResizeQuantity;
	private String				resType;
	private String				sqlTraceListeners;
	private String				statementCacheSize;
	private String				statementCacheType;
	private String				statementLeakReclaim;
	private String				statementLeakTimeoutInSeconds;
	private String				statementTimeoutInSeconds;
	private String				steadyPoolSize;
	private String				transactionIsolationLevel;
	private String				type;
	private String				validateAtmostOncePeriodInSeconds;
	private String				validationClassname;
	private String				validationTableName;
	private String				waitqueuelength;
	private String				wrapJdbcObjects;

	public DBGFInformation() {

		super();
	}

	public String getAllowNonComponentCallers() {

		return allowNonComponentCallers;
	}

	public String getAssociateWithThread() {

		return associateWithThread;
	}

	public String getAverageconnwaittime() {

		return averageconnwaittime;
	}

	public String getConnectionCreationRetryAttempts() {

		return connectionCreationRetryAttempts;
	}

	public String getConnectionCreationRetryIntervalInSeconds() {

		return connectionCreationRetryIntervalInSeconds;
	}

	public String getConnectionLeakReclaim() {

		return connectionLeakReclaim;
	}

	public String getConnectionLeakTimeoutInSeconds() {

		return connectionLeakTimeoutInSeconds;
	}

	public String getConnectionValidationMethod() {

		return connectionValidationMethod;
	}

	public String getConnrequestwaittime() {

		return connrequestwaittime;
	}

	public String getDatasourceClassname() {

		return datasourceClassname;
	}

	public String getDeploymentOrder() {

		return deploymentOrder;
	}

	public String getDescription() {

		return description;
	}

	public String getDriverClassname() {

		return driverClassname;
	}

	public String getFailAllConnections() {

		return failAllConnections;
	}

	public String getIdleTimeoutInSeconds() {

		return idleTimeoutInSeconds;
	}

	public String getInitSql() {

		return initSql;
	}

	public String getIsConnectionValidationRequired() {

		return isConnectionValidationRequired;
	}

	public String getIsIsolationLevelGuaranteed() {

		return isIsolationLevelGuaranteed;
	}

	public String getLazyConnectionAssociation() {

		return lazyConnectionAssociation;
	}

	public String getLazyConnectionEnlistment() {

		return lazyConnectionEnlistment;
	}

	public String getMatchConnections() {

		return matchConnections;
	}

	public String getMaxConnectionUsageCount() {

		return maxConnectionUsageCount;
	}

	public String getMaxPoolSize() {

		return maxPoolSize;
	}

	public String getMaxWaitTimeInMillis() {

		return maxWaitTimeInMillis;
	}

	public String getName() {

		return name;
	}

	public String getNonTransactionalConnections() {

		return nonTransactionalConnections;
	}

	public String getNumconnacquired() {

		return numconnacquired;
	}

	public String getNumconncreated() {

		return numconncreated;
	}

	public String getNumconndestroyed() {

		return numconndestroyed;
	}

	public String getNumconnfailedvalidation() {

		return numconnfailedvalidation;
	}

	public String getNumconnfree() {

		return numconnfree;
	}

	public String getNumconnnotsuccessfullymatched() {

		return numconnnotsuccessfullymatched;
	}

	public String getNumconnreleased() {

		return numconnreleased;
	}

	public String getNumconnsuccessfullymatched() {

		return numconnsuccessfullymatched;
	}

	public String getNumconntimedout() {

		return numconntimedout;
	}

	public String getNumconnused() {

		return numconnused;
	}

	public String getNumpotentialconnleak() {

		return numpotentialconnleak;
	}

	public String getObjectType() {

		return objectType;
	}

	public String getPing() {

		return ping;
	}

	public String getPooling() {

		return pooling;
	}

	public String getPoolResizeQuantity() {

		return poolResizeQuantity;
	}

	public String getResType() {

		return resType;
	}

	public String getSqlTraceListeners() {

		return sqlTraceListeners;
	}

	public String getStatementCacheSize() {

		return statementCacheSize;
	}

	public String getStatementCacheType() {

		return statementCacheType;
	}

	public String getStatementLeakReclaim() {

		return statementLeakReclaim;
	}

	public String getStatementLeakTimeoutInSeconds() {

		return statementLeakTimeoutInSeconds;
	}

	public String getStatementTimeoutInSeconds() {

		return statementTimeoutInSeconds;
	}

	public String getSteadyPoolSize() {

		return steadyPoolSize;
	}

	public String getTransactionIsolationLevel() {

		return transactionIsolationLevel;
	}

	public String getType() {

		return type;
	}

	public String getValidateAtmostOncePeriodInSeconds() {

		return validateAtmostOncePeriodInSeconds;
	}

	public String getValidationClassname() {

		return validationClassname;
	}

	public String getValidationTableName() {

		return validationTableName;
	}

	public String getWaitqueuelength() {

		return waitqueuelength;
	}

	public String getWrapJdbcObjects() {

		return wrapJdbcObjects;
	}

	public void setAllowNonComponentCallers(String allowNonComponentCallers) {

		this.allowNonComponentCallers = allowNonComponentCallers;
	}

	public void setAssociateWithThread(String associateWithThread) {

		this.associateWithThread = associateWithThread;
	}

	public void setAverageconnwaittime(String averageconnwaittime) {

		this.averageconnwaittime = averageconnwaittime;
	}

	public void setConnectionCreationRetryAttempts(String connectionCreationRetryAttempts) {

		this.connectionCreationRetryAttempts = connectionCreationRetryAttempts;
	}

	public void setConnectionCreationRetryIntervalInSeconds(String connectionCreationRetryIntervalInSeconds) {

		this.connectionCreationRetryIntervalInSeconds = connectionCreationRetryIntervalInSeconds;
	}

	public void setConnectionLeakReclaim(String connectionLeakReclaim) {

		this.connectionLeakReclaim = connectionLeakReclaim;
	}

	public void setConnectionLeakTimeoutInSeconds(String connectionLeakTimeoutInSeconds) {

		this.connectionLeakTimeoutInSeconds = connectionLeakTimeoutInSeconds;
	}

	public void setConnectionValidationMethod(String connectionValidationMethod) {

		this.connectionValidationMethod = connectionValidationMethod;
	}

	public void setConnrequestwaittime(String connrequestwaittime) {

		this.connrequestwaittime = connrequestwaittime;
	}

	public void setDatasourceClassname(String datasourceClassname) {

		this.datasourceClassname = datasourceClassname;
	}

	public void setDeploymentOrder(String deploymentOrder) {

		this.deploymentOrder = deploymentOrder;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public void setDriverClassname(String driverClassname) {

		this.driverClassname = driverClassname;
	}

	public void setFailAllConnections(String failAllConnections) {

		this.failAllConnections = failAllConnections;
	}

	public void setIdleTimeoutInSeconds(String idleTimeoutInSeconds) {

		this.idleTimeoutInSeconds = idleTimeoutInSeconds;
	}

	public void setInitSql(String initSql) {

		this.initSql = initSql;
	}

	public void setIsConnectionValidationRequired(String isConnectionValidationRequired) {

		this.isConnectionValidationRequired = isConnectionValidationRequired;
	}

	public void setIsIsolationLevelGuaranteed(String isIsolationLevelGuaranteed) {

		this.isIsolationLevelGuaranteed = isIsolationLevelGuaranteed;
	}

	public void setLazyConnectionAssociation(String lazyConnectionAssociation) {

		this.lazyConnectionAssociation = lazyConnectionAssociation;
	}

	public void setLazyConnectionEnlistment(String lazyConnectionEnlistment) {

		this.lazyConnectionEnlistment = lazyConnectionEnlistment;
	}

	public void setMatchConnections(String matchConnections) {

		this.matchConnections = matchConnections;
	}

	public void setMaxConnectionUsageCount(String maxConnectionUsageCount) {

		this.maxConnectionUsageCount = maxConnectionUsageCount;
	}

	public void setMaxPoolSize(String maxPoolSize) {

		this.maxPoolSize = maxPoolSize;
	}

	public void setMaxWaitTimeInMillis(String maxWaitTimeInMillis) {

		this.maxWaitTimeInMillis = maxWaitTimeInMillis;
	}

	public void setName(String name) {

		this.name = name;
	}

	public void setNonTransactionalConnections(String nonTransactionalConnections) {

		this.nonTransactionalConnections = nonTransactionalConnections;
	}

	public void setNumconnacquired(String numconnacquired) {

		this.numconnacquired = numconnacquired;
	}

	public void setNumconncreated(String numconncreated) {

		this.numconncreated = numconncreated;
	}

	public void setNumconndestroyed(String numconndestroyed) {

		this.numconndestroyed = numconndestroyed;
	}

	public void setNumconnfailedvalidation(String numconnfailedvalidation) {

		this.numconnfailedvalidation = numconnfailedvalidation;
	}

	public void setNumconnfree(String numconnfree) {

		this.numconnfree = numconnfree;
	}

	public void setNumconnnotsuccessfullymatched(String numconnnotsuccessfullymatched) {

		this.numconnnotsuccessfullymatched = numconnnotsuccessfullymatched;
	}

	public void setNumconnreleased(String numconnreleased) {

		this.numconnreleased = numconnreleased;
	}

	public void setNumconnsuccessfullymatched(String numconnsuccessfullymatched) {

		this.numconnsuccessfullymatched = numconnsuccessfullymatched;
	}

	public void setNumconntimedout(String numconntimedout) {

		this.numconntimedout = numconntimedout;
	}

	public void setNumconnused(String numconnused) {

		this.numconnused = numconnused;
	}

	public void setNumpotentialconnleak(String numpotentialconnleak) {

		this.numpotentialconnleak = numpotentialconnleak;
	}

	public void setObjectType(String objectType) {

		this.objectType = objectType;
	}

	public void setPing(String ping) {

		this.ping = ping;
	}

	public void setPooling(String pooling) {

		this.pooling = pooling;
	}

	public void setPoolResizeQuantity(String poolResizeQuantity) {

		this.poolResizeQuantity = poolResizeQuantity;
	}

	public void setResType(String resType) {

		this.resType = resType;
	}

	public void setSqlTraceListeners(String sqlTraceListeners) {

		this.sqlTraceListeners = sqlTraceListeners;
	}

	public void setStatementCacheSize(String statementCacheSize) {

		this.statementCacheSize = statementCacheSize;
	}

	public void setStatementCacheType(String statementCacheType) {

		this.statementCacheType = statementCacheType;
	}

	public void setStatementLeakReclaim(String statementLeakReclaim) {

		this.statementLeakReclaim = statementLeakReclaim;
	}

	public void setStatementLeakTimeoutInSeconds(String statementLeakTimeoutInSeconds) {

		this.statementLeakTimeoutInSeconds = statementLeakTimeoutInSeconds;
	}

	public void setStatementTimeoutInSeconds(String statementTimeoutInSeconds) {

		this.statementTimeoutInSeconds = statementTimeoutInSeconds;
	}

	public void setSteadyPoolSize(String steadyPoolSize) {

		this.steadyPoolSize = steadyPoolSize;
	}

	public void setTransactionIsolationLevel(String transactionIsolationLevel) {

		this.transactionIsolationLevel = transactionIsolationLevel;
	}

	public void setType(String type) {

		this.type = type;
	}

	public void setValidateAtmostOncePeriodInSeconds(String validateAtmostOncePeriodInSeconds) {

		this.validateAtmostOncePeriodInSeconds = validateAtmostOncePeriodInSeconds;
	}

	public void setValidationClassname(String validationClassname) {

		this.validationClassname = validationClassname;
	}

	public void setValidationTableName(String validationTableName) {

		this.validationTableName = validationTableName;
	}

	public void setWaitqueuelength(String waitqueuelength) {

		this.waitqueuelength = waitqueuelength;
	}

	public void setWrapJdbcObjects(String wrapJdbcObjects) {

		this.wrapJdbcObjects = wrapJdbcObjects;
	}
}
