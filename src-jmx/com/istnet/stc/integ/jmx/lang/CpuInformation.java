/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import static java.lang.management.ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME;
import static java.lang.management.ManagementFactory.RUNTIME_MXBEAN_NAME;
import static java.lang.management.ManagementFactory.newPlatformMXBeanProxy;

import com.icsp.integ.util.Common;
import com.istnet.stc.integ.jmx.JmxInformation;

import java.io.IOException;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.UndeclaredThrowableException;

import javax.management.InstanceNotFoundException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;

/**
 * @author Mostafa M.Shawky
 *
 */
public class CpuInformation implements JmxInformation {

	private static class Result {

		// long timeStamp;
		int		nCPUs;
		// String summary;
		long	processCpuTime	= -1L;
		long	upTime			= -1L;
	}

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public static void main(String[] args) throws Exception {

		// BigDecimal bdValue = new BigDecimal(999.1220112999);
		// int intValue = bdValue.intValue();
		// BigDecimal remaining = bdValue.subtract(new BigDecimal(intValue));
		// float fbdValue = bdValue.setScale(2,
		// BigDecimal.ROUND_UP).floatValue();
		// log.debug(fbdValue);
		// log.debug(bdValue.scale());
		// log.debug(Math.ceil(.100));
		// log.debug(Math.floor(.900));
		// log.debug(Math.rint(.9395));
		// log.debug(Math.sqrt(.99099));
		// JMXServersConnector js = new JMXServersConnector();
		// CPUUsageData d = new CPUUsageData(js
		// .getMBeanServerConnection("10.33.22.17"));
		//
		// while (true) {
		// log.debug(d.getCpuUsage());
		// Thread.currentThread().sleep(1000);
		// }
	}

	private String										className;
	private String										context;
	private String										host;
	private String										mBeanclass;
	private MBeanServerConnection						mbsc;
	private String										name;
	private OperatingSystemMXBean						operatingSystemMBean;
	private long										prevUpTime, prevProcessCpuTime;
	private com.sun.management.OperatingSystemMXBean	sunOperatingSystemMXBean;
	private String										type;

	/**
	 *
	 */
	public CpuInformation() {

		super();
	}

	public CpuInformation(MBeanServerConnection mbsc) {

		this.mbsc = mbsc;
	}

	/**
	 *
	 * @return
	 */
	Result collectCUPUsageInfo() {

		Result result = new Result();
		try {
			RuntimeMXBean rmBean = getRuntimeMXBean();
			OperatingSystemMXBean osMBean = getOperatingSystemMXBean();
			com.sun.management.OperatingSystemMXBean sunOSMBean = getSunOperatingSystemMXBean();
			{ // VM info
				if (rmBean != null) {
					result.upTime = rmBean.getUptime();
				}
				if (sunOSMBean != null) {
					result.processCpuTime = sunOSMBean.getProcessCpuTime();
				}
			}
			{ // Operating System info
				if (osMBean != null) {
					result.nCPUs = osMBean.getAvailableProcessors();
				}
			}
		} catch (IOException e) {
			return null;
		} catch (UndeclaredThrowableException e) {
			return null;
		}
		return result;
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
	 * @return the cpuUsage
	 * @throws IOException
	 */
	public float getCpuUsage() throws Exception {

		Result re = collectCUPUsageInfo();
		return Common.getScaleFloatPoint(updateCPUInfo(re));
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
	 *
	 * @return
	 * @throws IOException
	 */
	public OperatingSystemMXBean getOperatingSystemMXBean() throws IOException {

		if (mbsc == null) {
			return null;
		}
		operatingSystemMBean = newPlatformMXBeanProxy(mbsc, OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
		return operatingSystemMBean;
	}

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	public RuntimeMXBean getRuntimeMXBean() throws IOException {

		if (mbsc == null) {
			return null;
		}
		return newPlatformMXBeanProxy(mbsc, RUNTIME_MXBEAN_NAME, RuntimeMXBean.class);
	}

	/**
	 *
	 * @return
	 * @throws IOException
	 */
	public com.sun.management.OperatingSystemMXBean getSunOperatingSystemMXBean() throws IOException {

		try {
			ObjectName on = new ObjectName(OPERATING_SYSTEM_MXBEAN_NAME);
			if ((mbsc != null) && (sunOperatingSystemMXBean == null)) {
				if (mbsc.isInstanceOf(on, "com.sun.management.OperatingSystemMXBean")) {
					sunOperatingSystemMXBean = newPlatformMXBeanProxy(mbsc, OPERATING_SYSTEM_MXBEAN_NAME, com.sun.management.OperatingSystemMXBean.class);
				}
			}
		} catch (InstanceNotFoundException e) {
			return null;
		} catch (MalformedObjectNameException e) {
			return null; // should never reach here
		}
		return sunOperatingSystemMXBean;
	}

	/**
	 * @return the type
	 */
	public String getType() {

		return type;
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
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {

		this.type = type;
	}

	/**
	 *
	 * @param result
	 * @return
	 */
	public float updateCPUInfo(Result result) {

		float cpuUsage = 0;
		if ((prevUpTime > 0L) && (result.upTime > prevUpTime)) {
			// elapsedCpu is in ns and elapsedTime is in ms.
			long elapsedCpu = result.processCpuTime - prevProcessCpuTime;
			long elapsedTime = result.upTime - prevUpTime;
			// cpuUsage could go higher than 100% because elapsedTime
			// and elapsedCpu are not fetched simultaneously. Limit to
			// 99% to avoid Plotter showing a scale from 0% to 200%.
			cpuUsage = Math.min(99F, elapsedCpu / (elapsedTime * 10000F * result.nCPUs));
		}
		this.prevUpTime = result.upTime;
		this.prevProcessCpuTime = result.processCpuTime;
		return cpuUsage;
	}
}
