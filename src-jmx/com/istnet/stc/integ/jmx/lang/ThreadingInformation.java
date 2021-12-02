/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.istnet.stc.integ.jmx.JmxInformation;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ThreadingInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private long[]				allThreadIds;
	private Long				currentThreadCpuTime;
	private Boolean				currentThreadCpuTimeSupported;
	private Long				currentThreadUserTime;
	private Integer				daemonThreadCount;
	private Boolean				objectMonitorUsageSupported;
	private Integer				peakThreadCount;
	private Boolean				synchronizerUsageSupported;
	private Boolean				threadContentionMonitoringEnabled;
	private Boolean				threadContentionMonitoringSupported;
	private Integer				threadCount;
	private Boolean				threadCpuTimeEnabled;
	private Boolean				threadCpuTimeSupported;
	private Long				totalStartedThreadCount;

	/**
	 *
	 */
	public ThreadingInformation() {

		super();
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the allThreadIds
	 */
	public long[] getAllThreadIds() {

		return allThreadIds;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the currentThreadCpuTime
	 */
	public Long getCurrentThreadCpuTime() {

		return currentThreadCpuTime;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the currentThreadCpuTimeSupported
	 */
	public Boolean getCurrentThreadCpuTimeSupported() {

		return currentThreadCpuTimeSupported;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the currentThreadUserTime
	 */
	public Long getCurrentThreadUserTime() {

		return currentThreadUserTime;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the daemonThreadCount
	 */
	public Integer getDaemonThreadCount() {

		return daemonThreadCount;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the objectMonitorUsageSupported
	 */
	public Boolean getObjectMonitorUsageSupported() {

		return objectMonitorUsageSupported;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the peakThreadCount
	 */
	public Integer getPeakThreadCount() {

		return peakThreadCount;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the synchronizerUsageSupported
	 */
	public Boolean getSynchronizerUsageSupported() {

		return synchronizerUsageSupported;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the threadContentionMonitoringEnabled
	 */
	public Boolean getThreadContentionMonitoringEnabled() {

		return threadContentionMonitoringEnabled;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the threadContentionMonitoringSupported
	 */
	public Boolean getThreadContentionMonitoringSupported() {

		return threadContentionMonitoringSupported;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the threadCount
	 */
	public Integer getThreadCount() {

		return threadCount;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the threadCpuTimeEnabled
	 */
	public Boolean getThreadCpuTimeEnabled() {

		return threadCpuTimeEnabled;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the threadCpuTimeSupported
	 */
	public Boolean getThreadCpuTimeSupported() {

		return threadCpuTimeSupported;
	}

	/**
	 * This method used as getter for bean to hold the data
	 *
	 * @return the totalStartedThreadCount
	 */
	public Long getTotalStartedThreadCount() {

		return totalStartedThreadCount;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param allThreadIds
	 *            the allThreadIds to set
	 */
	public void setAllThreadIds(long[] allThreadIds) {

		this.allThreadIds = allThreadIds;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param currentThreadCpuTime
	 *            the currentThreadCpuTime to set
	 */
	public void setCurrentThreadCpuTime(Long currentThreadCpuTime) {

		this.currentThreadCpuTime = currentThreadCpuTime;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param currentThreadCpuTimeSupported
	 *            the currentThreadCpuTimeSupported to set
	 */
	public void setCurrentThreadCpuTimeSupported(Boolean currentThreadCpuTimeSupported) {

		this.currentThreadCpuTimeSupported = currentThreadCpuTimeSupported;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param currentThreadUserTime
	 *            the currentThreadUserTime to set
	 */
	public void setCurrentThreadUserTime(Long currentThreadUserTime) {

		this.currentThreadUserTime = currentThreadUserTime;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param daemonThreadCount
	 *            the daemonThreadCount to set
	 */
	public void setDaemonThreadCount(Integer daemonThreadCount) {

		this.daemonThreadCount = daemonThreadCount;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param objectMonitorUsageSupported
	 *            the objectMonitorUsageSupported to set
	 */
	public void setObjectMonitorUsageSupported(Boolean objectMonitorUsageSupported) {

		this.objectMonitorUsageSupported = objectMonitorUsageSupported;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param peakThreadCount
	 *            the peakThreadCount to set
	 */
	public void setPeakThreadCount(Integer peakThreadCount) {

		this.peakThreadCount = peakThreadCount;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param synchronizerUsageSupported
	 *            the synchronizerUsageSupported to set
	 */
	public void setSynchronizerUsageSupported(Boolean synchronizerUsageSupported) {

		this.synchronizerUsageSupported = synchronizerUsageSupported;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param threadContentionMonitoringEnabled
	 *            the threadContentionMonitoringEnabled to set
	 */
	public void setThreadContentionMonitoringEnabled(Boolean threadContentionMonitoringEnabled) {

		this.threadContentionMonitoringEnabled = threadContentionMonitoringEnabled;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param threadContentionMonitoringSupported
	 *            the threadContentionMonitoringSupported to set
	 */
	public void setThreadContentionMonitoringSupported(Boolean threadContentionMonitoringSupported) {

		this.threadContentionMonitoringSupported = threadContentionMonitoringSupported;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param threadCount
	 *            the threadCount to set
	 */
	public void setThreadCount(Integer threadCount) {

		this.threadCount = threadCount;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param threadCpuTimeEnabled
	 *            the threadCpuTimeEnabled to set
	 */
	public void setThreadCpuTimeEnabled(Boolean threadCpuTimeEnabled) {

		this.threadCpuTimeEnabled = threadCpuTimeEnabled;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param threadCpuTimeSupported
	 *            the threadCpuTimeSupported to set
	 */
	public void setThreadCpuTimeSupported(Boolean threadCpuTimeSupported) {

		this.threadCpuTimeSupported = threadCpuTimeSupported;
	}

	/**
	 * This method used as setter for bean to hold the data
	 *
	 * @param totalStartedThreadCount
	 *            the totalStartedThreadCount to set
	 */
	public void setTotalStartedThreadCount(Long totalStartedThreadCount) {

		this.totalStartedThreadCount = totalStartedThreadCount;
	}
}