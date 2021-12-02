/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.istnet.stc.integ.jmx.JmxInformation;

/**
 * @author Mostafa M.Shawky
 *
 */
public class OperatingSystemInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private String				arch;
	private Integer				availableProcessors;
	private String				className;
	private Long				committedVirtualMemorySize;
	private String				context;
	private Long				freePhysicalMemorySize;
	private Long				freeSwapSpaceSize;
	private String				host;
	private String				mBeanclass;
	private String				name;
	private Double				processCpuLoad;
	private Long				processCpuTime;
	private Double				systemCpuLoad;
	private Double				systemLoadAverage;
	private Long				totalPhysicalMemorySize;
	private Long				totalSwapSpaceSize;
	private String				type;
	private String				version;

	public OperatingSystemInformation() {

		super();
	}

	/**
	 * @return the arch
	 */
	public String getArch() {

		return arch;
	}

	/**
	 * @return the availableProcessors
	 */
	public Integer getAvailableProcessors() {

		return availableProcessors;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {

		return className;
	}

	/**
	 * @return the committedVirtualMemorySize
	 */
	public Long getCommittedVirtualMemorySize() {

		return committedVirtualMemorySize;
	}

	/**
	 * @return the context
	 */
	public String getContext() {

		return context;
	}

	/**
	 * @return the freePhysicalMemorySize
	 */
	public Long getFreePhysicalMemorySize() {

		return freePhysicalMemorySize;
	}

	/**
	 * @return the freeSwapSpaceSize
	 */
	public Long getFreeSwapSpaceSize() {

		return freeSwapSpaceSize;
	}

	/**
	 * @return the host
	 */
	public String getHost() {

		return host;
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
	 * @return the processCpuLoad
	 */
	public Double getProcessCpuLoad() {

		return processCpuLoad;
	}

	/**
	 * @return the processCpuTime
	 */
	public Long getProcessCpuTime() {

		return processCpuTime;
	}

	/**
	 * @return the systemCpuLoad
	 */
	public Double getSystemCpuLoad() {

		return systemCpuLoad;
	}

	/**
	 * @return the systemLoadAverage
	 */
	public Double getSystemLoadAverage() {

		return systemLoadAverage;
	}

	/**
	 * @return the totalPhysicalMemorySize
	 */
	public Long getTotalPhysicalMemorySize() {

		return totalPhysicalMemorySize;
	}

	/**
	 * @return the totalSwapSpaceSize
	 */
	public Long getTotalSwapSpaceSize() {

		return totalSwapSpaceSize;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {

		return version;
	}

	/**
	 * @param arch
	 *            the arch to set
	 */
	public void setArch(String arch) {

		this.arch = arch;
	}

	/**
	 * @param availableProcessors
	 *            the availableProcessors to set
	 */
	public void setAvailableProcessors(Integer availableProcessors) {

		this.availableProcessors = availableProcessors;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * @param committedVirtualMemorySize
	 *            the committedVirtualMemorySize to set
	 */
	public void setCommittedVirtualMemorySize(Long committedVirtualMemorySize) {

		this.committedVirtualMemorySize = committedVirtualMemorySize;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {

		this.context = context;
	}

	/**
	 * @param freePhysicalMemorySize
	 *            the freePhysicalMemorySize to set
	 */
	public void setFreePhysicalMemorySize(Long freePhysicalMemorySize) {

		this.freePhysicalMemorySize = freePhysicalMemorySize;
	}

	/**
	 * @param freeSwapSpaceSize
	 *            the freeSwapSpaceSize to set
	 */
	public void setFreeSwapSpaceSize(Long freeSwapSpaceSize) {

		this.freeSwapSpaceSize = freeSwapSpaceSize;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {

		this.host = host;
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
	 * @param processCpuLoad
	 *            the processCpuLoad to set
	 */
	public void setProcessCpuLoad(Double processCpuLoad) {

		this.processCpuLoad = processCpuLoad;
	}

	/**
	 * @param processCpuTime
	 *            the processCpuTime to set
	 */
	public void setProcessCpuTime(Long processCpuTime) {

		this.processCpuTime = processCpuTime;
	}

	/**
	 * @param systemCpuLoad
	 *            the systemCpuLoad to set
	 */
	public void setSystemCpuLoad(Double systemCpuLoad) {

		this.systemCpuLoad = systemCpuLoad;
	}

	/**
	 * @param systemLoadAverage
	 *            the systemLoadAverage to set
	 */
	public void setSystemLoadAverage(Double systemLoadAverage) {

		this.systemLoadAverage = systemLoadAverage;
	}

	/**
	 * @param totalPhysicalMemorySize
	 *            the totalPhysicalMemorySize to set
	 */
	public void setTotalPhysicalMemorySize(Long totalPhysicalMemorySize) {

		this.totalPhysicalMemorySize = totalPhysicalMemorySize;
	}

	/**
	 * @param totalSwapSpaceSize
	 *            the totalSwapSpaceSize to set
	 */
	public void setTotalSwapSpaceSize(Long totalSwapSpaceSize) {

		this.totalSwapSpaceSize = totalSwapSpaceSize;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {

		this.version = version;
	}
}