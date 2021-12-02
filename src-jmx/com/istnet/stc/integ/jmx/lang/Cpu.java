/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class Cpu extends JmxProvider {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * @param ip
	 * @param port
	 */
	public Cpu(String ip, int port) {

		super(ip, port);
	}

	protected ArrayList<?> getInformation() {

		ArrayList<CpuInformation> cpuInfo = new ArrayList<CpuInformation>();
		CpuInformation cpuInformation = new CpuInformation();
		cpuInfo.add(cpuInformation);
		return cpuInfo;
	}
}