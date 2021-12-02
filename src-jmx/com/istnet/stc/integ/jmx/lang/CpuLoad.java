/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import static java.lang.management.ManagementFactory.newPlatformMXBeanProxy;

import com.istnet.stc.integ.jmx.JmxInformation;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * @author Administrator
 *
 */
public class CpuLoad {

	private static class Result {

		float	cpuUsage		= 0;
		int		nCPUs;
		long	processCpuTime	= -1L;
		long	upTime			= -1L;
	}

	private static long						prevUpTime, prevProcessCpuTime;
	private static Result					result;
	private static OperatingSystemMXBean	sunOSMBean;
	static {}
	private RuntimeInformation				runtimeInformation;

	@SuppressWarnings ("unchecked")
	public CpuLoad() {

		super();
		try {
			MBeanServerConnection mbsc = null;
			JMXConnector jmxc = null;
			JMXServiceURL url = null;
			url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + "172.20.244.200" + ":" + 9696 + "/jmxrmi");
			jmxc = JMXConnectorFactory.connect(url);
			mbsc = jmxc.getMBeanServerConnection();
			com.istnet.stc.integ.jmx.lang.Runtime runtime = new com.istnet.stc.integ.jmx.lang.Runtime("172.20.244.200", 9696);
			for (JmxInformation jmxInformation : ((ArrayList<JmxInformation>) runtime.getInformation())) {
				runtimeInformation = ((RuntimeInformation) jmxInformation);
				result.upTime = ((RuntimeInformation) jmxInformation).getUptime();
				System.out.println("Up Time >>> 1 " + ((RuntimeInformation) jmxInformation).getUptime());
			}
			// rmBean = newPlatformMXBeanProxy(mbsc, RUNTIME_MXBEAN_NAME,
			// RuntimeMXBean.class);
			// rmBean = ManagementFactory.getRuntimeMXBean();
			// reperisco l'MBean relativo al sunOS
			// sunOSMBean =
			// ManagementFactory.newPlatformMXBeanProxy(ManagementFactory.getPlatformMBeanServer(),
			// ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
			// OperatingSystemMXBean.class);
			sunOSMBean = newPlatformMXBeanProxy(mbsc, ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
			result = new Result();
			result.nCPUs = sunOSMBean.getAvailableProcessors();
			System.out.println(" AvailableProcessors " + result.nCPUs);
			// result.upTime = rmBean.getUptime();
			// System.out.println("Up Time >>> 1 " + result.upTime);
			result.processCpuTime = sunOSMBean.getProcessCpuTime();
			System.out.println("Process Cpu Time >>> 2 " + result.processCpuTime);
		} catch (Exception e) {
			System.err.println(CpuLoad.class.getSimpleName() + " exception: " + e.getMessage());
		}
	}

	public float getCPULoad() {

		result.upTime = runtimeInformation.getUptime();
		// result.upTime = rmBean.getUptime();
		result.processCpuTime = sunOSMBean.getProcessCpuTime();
		if ((result.upTime > 0L) && (result.processCpuTime >= 0L)) {
			updateCPUInfo();
		}
		return result.cpuUsage;
	}

	public void updateCPUInfo() {

		if ((prevUpTime > 0L) && (result.upTime > prevUpTime)) {
			// elapsedCpu is in ns and elapsedTime is in ms.
			long elapsedCpu = result.processCpuTime - prevProcessCpuTime;
			long elapsedTime = result.upTime - prevUpTime;
			// cpuUsage could go higher than 100% because elapsedTime
			// and elapsedCpu are not fetched simultaneously. Limit to
			// 99% to avoid Plotter showing a scale from 0% to 200%.
			result.cpuUsage = Math.round(Math.min(100F, elapsedCpu / (elapsedTime * 10000F * 2)));
		}
		prevUpTime = result.upTime;
		prevProcessCpuTime = result.processCpuTime;
	}
}