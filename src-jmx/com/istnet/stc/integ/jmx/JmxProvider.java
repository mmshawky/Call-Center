/**
 *
 */
package com.istnet.stc.integ.jmx;

import com.icsp.integ.exception.ServiceApplicationException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mostafa M.Shawky
 *
 */
public class JmxProvider implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	protected String			ip;
	protected int				port;

	public JmxProvider(String ip, int port) {

		this.port = port;
		this.ip = ip;
	}

	/**
	 * This function generic for used by all JMX POJO for call passed function
	 * name
	 *
	 * @param mbeanName
	 * @param functionName
	 * @param prams
	 * @return result
	 * @throws ServiceExceptionFactory
	 */
	public Object callFunction(String mbeanName, String functionName, Object... prams) throws ServiceApplicationException {

		JmxConnector connector = new JmxConnector();
		return connector.invokeMBean(mbeanName, functionName, prams, ip, port);
	}

	/**
	 * This function generic for used by all JMX POJO return {@link ArrayList} of JMX information
	 *
	 * @param mbeanName
	 * @param mbeanTarget
	 * @return
	 * @throws ServiceExceptionFactory
	 */
	public ArrayList<JmxInformation> getInformation(String mbeanName, Class<?> mbeanTarget) throws ServiceApplicationException {

		JmxConnector connector = new JmxConnector();
		return connector.getMBeanInformation(mbeanName, mbeanTarget, ip, port);
	}
}