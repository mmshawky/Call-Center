/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.icsp.integ.util.Common;
import com.istnet.stc.integ.jmx.JmxInformation;

import java.io.IOException;
import java.lang.management.MemoryUsage;

import javax.management.openmbean.CompositeDataSupport;

/**
 * @author Mostafa M.Shawky
 *
 */
public class MemoryInformation implements JmxInformation {

	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;
	private String					className;
	private String					context;
	private CompositeDataSupport	heapMemoryUsage;
	private String					host;
	private String					mBeanclass;
	private String					name;
	private CompositeDataSupport	nonHeapMemoryUsage;
	private Integer					objectPendingFinalizationCount;
	private Double					totalJVMMemory, uasgeJVMHeapMemory, percentageUasgeJVMMemory;
	private String					type;
	private Boolean					verbose;

	public MemoryInformation() {

		super();
	}

	/**
	 * @return the className
	 */
	public String getClassName() {

		return className;
	}

	/**
	 * @return the context
	 */
	public String getContext() {

		return context;
	}

	/**
	 * @return the heapMemoryUsage
	 */
	public CompositeDataSupport getHeapMemoryUsage() {

		return heapMemoryUsage;
	}

	public MemoryUsage getHeapMemoryUsageData() {

		return MemoryUsage.from(heapMemoryUsage);
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
	 * @return the nonHeapMemoryUsage
	 */
	public CompositeDataSupport getNonHeapMemoryUsage() {

		return nonHeapMemoryUsage;
	}

	public MemoryUsage getNonHeapMemoryUsageData() {

		return MemoryUsage.from(nonHeapMemoryUsage);
	}

	/**
	 * @return the objectPendingFinalizationCount
	 */
	public Integer getObjectPendingFinalizationCount() {

		return objectPendingFinalizationCount;
	}

	/**
	 * @return the percentageJVMMemory
	 * @throws Exception
	 */
	public Double getPercentageUasgeJVMMemory() throws Exception {

		try {
			percentageUasgeJVMMemory = (getUasgeJVMHeapMemory() / getTotalJVMMemory()) * 100;
			percentageUasgeJVMMemory = (double) Common.getScaleFloatPoint(percentageUasgeJVMMemory);
		} catch (Exception e) {
			percentageUasgeJVMMemory = 0.0;
		}
		return percentageUasgeJVMMemory;
	}

	/**
	 * @return the totalJVMMemory
	 */
	public Double getTotalJVMMemory() throws Exception {

		MemoryUsage memoryUsage = getHeapMemoryUsageData();
		if (memoryUsage != null) {
			totalJVMMemory = (double) (memoryUsage.getMax() / 1048576);
		}
		return totalJVMMemory;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
	}

	/**
	 * @return the uasgeJVMMemory
	 * @throws IOException
	 * @throws IOException
	 */
	public Double getUasgeJVMHeapMemory() throws Exception {

		MemoryUsage memoryUsage = getHeapMemoryUsageData();
		if (memoryUsage != null) {
			uasgeJVMHeapMemory = (double) memoryUsage.getUsed() / 1048576;
		}
		return uasgeJVMHeapMemory;
	}

	/**
	 * @return the verbose
	 */
	public Boolean getVerbose() {

		return verbose;
	}

	/**
	 * @return the verbose
	 */
	public Boolean isVerbose() {

		return verbose;
	}

	/**
	 * @param className
	 *            the className to set
	 */
	public void setClassName(String className) {

		this.className = className;
	}

	/**
	 * @param context
	 *            the context to set
	 */
	public void setContext(String context) {

		this.context = context;
	}

	/**
	 * @param heapMemoryUsage
	 *            the heapMemoryUsage to set
	 */
	public void setHeapMemoryUsage(CompositeDataSupport heapMemoryUsage) {

		this.heapMemoryUsage = heapMemoryUsage;
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
	 * @param nonHeapMemoryUsage
	 *            the nonHeapMemoryUsage to set
	 */
	public void setNonHeapMemoryUsage(CompositeDataSupport nonHeapMemoryUsage) {

		this.nonHeapMemoryUsage = nonHeapMemoryUsage;
	}

	/**
	 * @param objectPendingFinalizationCount
	 *            the objectPendingFinalizationCount to set
	 */
	public void setObjectPendingFinalizationCount(Integer objectPendingFinalizationCount) {

		this.objectPendingFinalizationCount = objectPendingFinalizationCount;
	}

	/**
	 * @param percentageUasgeJVMMemory
	 *            the percentageUasgeJVMMemory to set
	 */
	public void setPercentageUasgeJVMMemory(Double percentageUasgeJVMMemory) {

		this.percentageUasgeJVMMemory = percentageUasgeJVMMemory;
	}

	/**
	 * @param totalJVMMemory
	 *            the totalJVMMemory to set
	 */
	public void setTotalJVMMemory(Double totalJVMMemory) {

		this.totalJVMMemory = totalJVMMemory;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 * @param uasgeJVMHeapMemory
	 *            the uasgeJVMHeapMemory to set
	 */
	public void setUasgeJVMHeapMemory(Double uasgeJVMHeapMemory) {

		this.uasgeJVMHeapMemory = uasgeJVMHeapMemory;
	}

	/**
	 * @param verbose
	 *            the verbose to set
	 */
	public void setVerbose(Boolean verbose) {

		this.verbose = verbose;
	}
}