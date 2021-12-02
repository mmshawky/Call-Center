/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.icsp.integ.exception.ServiceApplicationException;
import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;

/**
 * @author Mostafa M.Shawky
 *
 */
public class OperatingSystem extends JmxProvider {

	public static final String	MBEAN_OS			= "java.lang:type=OperatingSystem";
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 *
	 */
	public OperatingSystem(String ip, int port) {

		super(ip, port);
	}

	public Object callFunction(String functionName, Object... prams) throws ServiceApplicationException {

		return super.callFunction(MBEAN_OS, functionName, prams);
	}

	public ArrayList<?> getInformation() throws ServiceApplicationException {

		return super.getInformation(MBEAN_OS, OperatingSystemInformation.class);
	}
}