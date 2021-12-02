/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.istnet.stc.integ.jmx.JmxInformation;

import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;

/**
 * @author Mostafa M.Shawky
 *
 */
public class RuntimeInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private String				bootClassPath;
	private Boolean				bootClassPathSupported;
	private String				className;
	private String				classPath;
	private String				context;
	private String				host;
	private String[]			inputArguments;
	private String				libraryPath;
	private String				managementSpecVersion;
	private String				mBeanclass;
	private String				name;
	private String				specName;
	private String				specVendor;
	private String				specVersion;
	private Long				startTime;
	private TabularDataSupport	systemProperties;
	private String				type;
	private Long				uptime;
	private String				vmName;
	private String				vmVendor;
	private String				vmVersion;

	/**
	 *
	 */
	public RuntimeInformation() {

		super();
	}

	/**
	 * @return the bootClassPath
	 */
	public String getBootClassPath() {

		return bootClassPath;
	}

	/**
	 * @return the bootClassPathSupported
	 */
	public Boolean getBootClassPathSupported() {

		return bootClassPathSupported;
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

	/**
	 * @return the context
	 */
	public String getContext() {

		return context;
	}

	/**
	 * @return the host
	 */
	public String getHost() {

		return host;
	}

	/**
	 * @return the inputArguments
	 */
	public String[] getInputArguments() {

		return inputArguments;
	}

	/**
	 * @return the libraryPath
	 */
	public String getLibraryPath() {

		return libraryPath;
	}

	/**
	 * @return the managementSpecVersion
	 */
	public String getManagementSpecVersion() {

		return managementSpecVersion;
	}

	/**
	 * @return the mBeanclass
	 */
	public String getmBeanclass() {

		return mBeanclass;
	}

	/**
	 * @return the name
	 */
	public String getName() {

		return name;
	}

	/**
	 * @return the specName
	 */
	public String getSpecName() {

		return specName;
	}

	/**
	 * @return the specVendor
	 */
	public String getSpecVendor() {

		return specVendor;
	}

	/**
	 * @return the specVersion
	 */
	public String getSpecVersion() {

		return specVersion;
	}

	/**
	 * @return the startTime
	 */
	public Long getStartTime() {

		return startTime;
	}

	/**
	 * @return the systemProperties
	 */
	public TabularDataSupport getSystemProperties() {

		return systemProperties;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return the uptime
	 */
	public Long getUptime() {

		return uptime;
	}

	/**
	 * @return the vmName
	 */
	public String getVmName() {

		return vmName;
	}

	/**
	 * @return the vmVendor
	 */
	public String getVmVendor() {

		return vmVendor;
	}

	/**
	 * @return the vmVersion
	 */
	public String getVmVersion() {

		return vmVersion;
	}

	/**
	 * @param bootClassPath
	 *            the bootClassPath to set
	 */
	public void setBootClassPath(String bootClassPath) {

		this.bootClassPath = bootClassPath;
	}

	/**
	 * @param bootClassPathSupported
	 *            the bootClassPathSupported to set
	 */
	public void setBootClassPathSupported(Boolean bootClassPathSupported) {

		this.bootClassPathSupported = bootClassPathSupported;
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

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {

		this.context = context;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {

		this.host = host;
	}

	/**
	 * @param inputArguments
	 *            the inputArguments to set
	 */
	public void setInputArguments(String[] inputArguments) {

		this.inputArguments = inputArguments;
	}

	/**
	 * @param libraryPath
	 *            the libraryPath to set
	 */
	public void setLibraryPath(String libraryPath) {

		this.libraryPath = libraryPath;
	}

	/**
	 * @param managementSpecVersion
	 *            the managementSpecVersion to set
	 */
	public void setManagementSpecVersion(String managementSpecVersion) {

		this.managementSpecVersion = managementSpecVersion;
	}

	/**
	 * @param mBeanclass
	 *            the mBeanclass to set
	 */
	public void setmBeanclass(String mBeanclass) {

		this.mBeanclass = mBeanclass;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {

		this.name = name;
	}

	/**
	 * @param specName
	 *            the specName to set
	 */
	public void setSpecName(String specName) {

		this.specName = specName;
	}

	/**
	 * @param specVendor
	 *            the specVendor to set
	 */
	public void setSpecVendor(String specVendor) {

		this.specVendor = specVendor;
	}

	/**
	 * @param specVersion
	 *            the specVersion to set
	 */
	public void setSpecVersion(String specVersion) {

		this.specVersion = specVersion;
	}

	/**
	 * @param startTime
	 *            the startTime to set
	 */
	public void setStartTime(Long startTime) {

		this.startTime = startTime;
	}

	/**
	 * @param systemProperties
	 *            the systemProperties to set
	 */
	public void setSystemProperties(TabularData systemProperties) {

		this.systemProperties = (TabularDataSupport) systemProperties;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * @param uptime
	 *            the uptime to set
	 */
	public void setUptime(Long uptime) {

		this.uptime = uptime;
	}

	/**
	 * @param vmName
	 *            the vmName to set
	 */
	public void setVmName(String vmName) {

		this.vmName = vmName;
	}

	/**
	 * @param vmVendor
	 *            the vmVendor to set
	 */
	public void setVmVendor(String vmVendor) {

		this.vmVendor = vmVendor;
	}

	/**
	 * @param vmVersion
	 *            the vmVersion to set
	 */
	public void setVmVersion(String vmVersion) {

		this.vmVersion = vmVersion;
	}
}
