/**
 *
 */
package com.istnet.stc.integ.jmx.lang;

import com.icsp.integ.exception.ServiceApplicationException;
import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class Runtime extends JmxProvider {

	public static final String	MBEAN_RUNTIME		= "java.lang:type=Runtime";
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	/**
	 * @param ip
	 * @param port
	 */
	public Runtime(String ip, int port) {

		super(ip, port);
	}

	public Object callFunction(String functionName, Object... prams) throws ServiceApplicationException {

		return super.callFunction(MBEAN_RUNTIME, functionName, prams);
	}

	public ArrayList<?> getInformation() throws ServiceApplicationException {

		return super.getInformation(MBEAN_RUNTIME, RuntimeInformation.class);
	}
}