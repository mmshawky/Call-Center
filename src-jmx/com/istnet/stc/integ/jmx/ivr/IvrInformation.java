/**
 *
 */
package com.istnet.stc.integ.jmx.ivr;

import com.istnet.stc.integ.jmx.JmxInformation;

/**
 * @author Mostafa M.Shawky
 *
 */
public class IvrInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private Long				activeCallCount;
	private Integer				availablePortsStatus;
	private Object				calFlowServiceObject;
	private Long				callsError;
	private Long				callsReceived;
	private String				className;
	private String				classPath;
	private Integer				concurrentCallersStatus;
	private String				context;
	private Boolean				dumpFactoryConfig;
	private Boolean				dumpScript;
	private Boolean				enableGC;
	private Integer				gCTimeOut;
	private String				host;
	private int					isDumpFactoryConfig;
	private int					isDumpScript;
	private int					isEnableGC;
	private int					isLogWarnings;
	private int					isShutDown;
	private Integer				licensePortsStatus;
	private String				licenseString;
	private Boolean				logWarnings;
	private String				mBeanclass;
	private String				mediaPathSeparator;
	private String				name;
	private int					noOfPorts;
	private Integer				numberOfPorts;
	private int					port;
	private String				scriptFilename;
	private String				serverIp;
	private String				serviceStatus;
	private Boolean				shutDown;
	private String				source;
	private String				starttime;
	private String				status;
	private int					timeOutGC;
	private long				totalActiveCalls;
	private long				totalErrorCalls;
	private long				totalReceivedCalls;
	private String				type;

	/**
	 *
	 */
	public IvrInformation() {

		super();
	}

	/**
	 * @return the activeCallCount
	 */
	public Long getActiveCallCount() {

		return activeCallCount;
	}

	public Integer getAvailablePortsStatus() {

		return availablePortsStatus;
	}

	/**
	 * @return the calFlowServiceObject
	 */
	public Object getCalFlowServiceObject() {

		return calFlowServiceObject;
	}

	/**
	 * @return the callsError
	 */
	public Long getCallsError() {

		return callsError;
	}

	/**
	 * @return the callsReceived
	 */
	public Long getCallsReceived() {

		return callsReceived;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {

		return className;
	}

	/**
	 * @return the classPath
	 */
	public String getClassPath() {

		return classPath;
	}

	public Integer getConcurrentCallersStatus() {

		return concurrentCallersStatus;
	}

	/**
	 * @return the context
	 */
	public String getContext() {

		return context;
	}

	/**
	 * @return the gCTimeOut
	 */
	public Integer getGCTimeOut() {

		return gCTimeOut;
	}

	/**
	 * @return the host
	 */
	public String getHost() {

		return host;
	}

	/**
	 * @return the isDumpFactoryConfig
	 */
	public int getIsDumpFactoryConfig() {

		return isDumpFactoryConfig;
	}

	/**
	 * @return the isDumpScript
	 */
	public int getIsDumpScript() {

		return isDumpScript;
	}

	/**
	 * @return the isEnableGC
	 */
	public int getIsEnableGC() {

		return isEnableGC;
	}

	/**
	 * @return the isLogWarnings
	 */
	public int getIsLogWarnings() {

		return isLogWarnings;
	}

	/**
	 * @return the isShutDown
	 */
	public int getIsShutDown() {

		return isShutDown;
	}

	public Integer getLicensePortsStatus() {

		return licensePortsStatus;
	}

	/**
	 * @return the licenseString
	 */
	public String getLicenseString() {

		return licenseString;
	}

	/**
	 * @return the mBeanclass
	 */
	public String getmBeanclass() {

		return mBeanclass;
	}

	/**
	 * @return the mediaPathSeparator
	 */
	public String getMediaPathSeparator() {

		return mediaPathSeparator;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @return the noOfPorts
	 */
	public int getNoOfPorts() {

		return noOfPorts;
	}

	/**
	 * @return the numberOfPorts
	 */
	public Integer getNumberOfPorts() {

		return numberOfPorts;
	}

	/**
	 * @return the port
	 */
	public int getPort() {

		return port;
	}

	/**
	 * @return the scriptFilename
	 */
	public String getScriptFilename() {

		return scriptFilename;
	}

	/**
	 * @return the serverIp
	 */
	public String getServerIp() {

		return serverIp;
	}

	/**
	 * @return the serviceStatus
	 */
	public String getServiceStatus() {

		return serviceStatus;
	}

	/**
	 * @return the source
	 */
	public String getSource() {

		return source;
	}

	/**
	 * @return the starttime
	 */
	public String getStarttime() {

		return starttime;
	}

	public String getStatus() {

		return status;
	}

	/**
	 * @return the timeOutGC
	 */
	public int getTimeOutGC() {

		return timeOutGC;
	}

	/**
	 * @return the totalActiveCalls
	 */
	public long getTotalActiveCalls() {

		return totalActiveCalls;
	}

	/**
	 * @return the totalErrorCalls
	 */
	public long getTotalErrorCalls() {

		return totalErrorCalls;
	}

	/**
	 * @return the totalReceivedCalls
	 */
	public long getTotalReceivedCalls() {

		return totalReceivedCalls;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return the dumpFactoryConfig
	 */
	public Boolean isDumpFactoryConfig() {

		return dumpFactoryConfig;
	}

	/**
	 * @return the dumpScript
	 */
	public Boolean isDumpScript() {

		return dumpScript;
	}

	/**
	 * @return the enableGC
	 */
	public Boolean isEnableGC() {

		return enableGC;
	}

	/**
	 * @return the logWarnings
	 */
	public Boolean isLogWarnings() {

		return logWarnings;
	}

	/**
	 * @return the shutDown
	 */
	public Boolean isShutDown() {

		return shutDown;
	}

	/**
	 * @param activeCallCount
	 *            the activeCallCount to set
	 */
	public void setActiveCallCount(Long activeCallCount) {

		this.activeCallCount = activeCallCount;
	}

	public void setAvailablePortsStatus(Integer availablePortsStatus) {

		this.availablePortsStatus = availablePortsStatus;
	}

	/**
	 * @param calFlowServiceObject
	 *            the calFlowServiceObject to set
	 */
	public void setCalFlowServiceObject(Object calFlowServiceObject) {

		this.calFlowServiceObject = calFlowServiceObject;
	}

	/**
	 * @param callsError
	 *            the callsError to set
	 */
	public void setCallsError(Long callsError) {

		this.callsError = callsError;
	}

	/**
	 * @param callsReceived
	 *            the callsReceived to set
	 */
	public void setCallsReceived(Long callsReceived) {

		this.callsReceived = callsReceived;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * @param classPath
	 *            the classPath to set
	 */
	public void setClassPath(String classPath) {

		this.classPath = classPath;
	}

	public void setConcurrentCallersStatus(Integer concurrentCallersStatus) {

		this.concurrentCallersStatus = concurrentCallersStatus;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {

		this.context = context;
	}

	/**
	 * @param dumpFactoryConfig
	 *            the dumpFactoryConfig to set
	 */
	public void setDumpFactoryConfig(Boolean dumpFactoryConfig) {

		this.dumpFactoryConfig = dumpFactoryConfig;
	}

	/**
	 * @param dumpScript
	 *            the dumpScript to set
	 */
	public void setDumpScript(Boolean dumpScript) {

		this.dumpScript = dumpScript;
	}

	/**
	 * @param enableGC
	 *            the enableGC to set
	 */
	public void setEnableGC(Boolean enableGC) {

		this.enableGC = enableGC;
	}

	/**
	 * @param gCTimeOut
	 *            the gCTimeOut to set
	 */
	public void setGCTimeOut(Integer gCTimeOut) {

		this.gCTimeOut = gCTimeOut;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {

		this.host = host;
	}

	/**
	 * @param isDumpFactoryConfig
	 *            the isDumpFactoryConfig to set
	 */
	public void setIsDumpFactoryConfig(int isDumpFactoryConfig) {

		this.isDumpFactoryConfig = isDumpFactoryConfig;
	}

	/**
	 * @param isDumpScript
	 *            the isDumpScript to set
	 */
	public void setIsDumpScript(int isDumpScript) {

		this.isDumpScript = isDumpScript;
	}

	/**
	 * @param isEnableGC
	 *            the isEnableGC to set
	 */
	public void setIsEnableGC(int isEnableGC) {

		this.isEnableGC = isEnableGC;
	}

	/**
	 * @param isLogWarnings
	 *            the isLogWarnings to set
	 */
	public void setIsLogWarnings(int isLogWarnings) {

		this.isLogWarnings = isLogWarnings;
	}

	/**
	 * @param isShutDown
	 *            the isShutDown to set
	 */
	public void setIsShutDown(int isShutDown) {

		this.isShutDown = isShutDown;
	}

	public void setLicensePortsStatus(Integer licensePortsStatus) {

		this.licensePortsStatus = licensePortsStatus;
	}

	/**
	 * @param licenseString
	 *            the licenseString to set
	 */
	public void setLicenseString(String licenseString) {

		this.licenseString = licenseString;
	}

	/**
	 * @param logWarnings
	 *            the logWarnings to set
	 */
	public void setLogWarnings(Boolean logWarnings) {

		this.logWarnings = logWarnings;
	}

	/**
	 * @param mBeanclass
	 *            the mBeanclass to set
	 */
	public void setmBeanclass(String mBeanclass) {

		this.mBeanclass = mBeanclass;
	}

	/**
	 * @param mediaPathSeparator
	 *            the mediaPathSeparator to set
	 */
	public void setMediaPathSeparator(String mediaPathSeparator) {

		this.mediaPathSeparator = mediaPathSeparator;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @param noOfPorts
	 *            the noOfPorts to set
	 */
	public void setNoOfPorts(int noOfPorts) {

		this.noOfPorts = noOfPorts;
	}

	/**
	 * @param numberOfPorts
	 *            the numberOfPorts to set
	 */
	public void setNumberOfPorts(Integer numberOfPorts) {

		this.numberOfPorts = numberOfPorts;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {

		this.port = port;
	}

	/**
	 * @param scriptFilename
	 *            the scriptFilename to set
	 */
	public void setScriptFilename(String scriptFilename) {

		this.scriptFilename = scriptFilename;
	}

	/**
	 * @param serverIp
	 *            the serverIp to set
	 */
	public void setServerIp(String serverIp) {

		this.serverIp = serverIp;
	}

	/**
	 * @param serviceStatus
	 *            the serviceStatus to set
	 */
	public void setServiceStatus(String serviceStatus) {

		this.serviceStatus = serviceStatus;
	}

	/**
	 * @param shutDown
	 *            the shutDown to set
	 */
	public void setShutDown(Boolean shutDown) {

		this.shutDown = shutDown;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {

		this.source = source;
	}

	/**
	 * @param starttime
	 *            the starttime to set
	 */
	public void setStarttime(String starttime) {

		this.starttime = starttime;
	}

	public void setStatus(String status) {

		this.status = status;
	}

	/**
	 * @param timeOutGC
	 *            the timeOutGC to set
	 */
	public void setTimeOutGC(int timeOutGC) {

		this.timeOutGC = timeOutGC;
	}

	/**
	 * @param totalActiveCalls
	 *            the totalActiveCalls to set
	 */
	public void setTotalActiveCalls(long totalActiveCalls) {

		this.totalActiveCalls = totalActiveCalls;
	}

	/**
	 * @param totalErrorCalls
	 *            the totalErrorCalls to set
	 */
	public void setTotalErrorCalls(long totalErrorCalls) {

		this.totalErrorCalls = totalErrorCalls;
	}

	/**
	 * @param totalReceivedCalls
	 *            the totalReceivedCalls to set
	 */
	public void setTotalReceivedCalls(long totalReceivedCalls) {

		this.totalReceivedCalls = totalReceivedCalls;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}
}