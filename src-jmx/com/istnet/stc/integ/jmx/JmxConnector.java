/**
 *
 */
package com.istnet.stc.integ.jmx;

import static com.icsp.integ.util.Common.getSingletonExecutorInstance;
import static com.icsp.integ.util.Common.toUpperCaseFirstChar;
import static com.icsp.integ.util.Constants.RMI_TIMEOUT;

import com.icsp.integ.exception.ServiceApplicationException;
import com.icsp.integ.exception.ServiceTimeoutException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import javax.management.Descriptor;
import javax.management.JMX;
import javax.management.MBeanAttributeInfo;
import javax.management.MBeanInfo;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.log4j.Logger;

/**
 * @author Mostafa M.Shawky
 *
 */
public class JmxConnector {

	/**
	 *
	 * @author Administrator
	 *
	 */
	public class CallableJMXConnector implements Callable<JMXConnector> {

		int		port;
		String	serverIP;

		CallableJMXConnector(String serverIP, int port) {

			this.serverIP = serverIP;
			this.port = port;
		}

		@Override
		public JMXConnector call() throws Exception {

			JMXServiceURL url = null;
			log.debug("IP [" + serverIP + "] Port [" + port + "]");
			url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://" + serverIP + ":" + port + "/jmxrmi");
			return JMXConnectorFactory.connect(url);
		}
	}

	private static Logger	log	= Logger.getLogger(JmxConnector.class);

	/**
	 * This method for check String wrapper which primitive type
	 *
	 * @param type
	 * @return
	 */
	private static Class<?> getPrimitiveType(String type) {

		HashMap<String, Class<?>> ret = new HashMap<String, Class<?>>();
		ret.put("boolean", Boolean.class);
		ret.put("char", Character.class);
		ret.put("byte", Byte.class);
		ret.put("short", Short.class);
		ret.put("int", Integer.class);
		ret.put("long", Long.class);
		ret.put("float", Float.class);
		ret.put("double", Double.class);
		ret.put("void", Void.class);
		return ret.get(type);
	}

	/**
	 * @throws Exception
	 *
	 */
	public JmxConnector() {

		super();
	}

	/**
	 *
	 * @param serverIP
	 * @param port
	 * @return
	 * @throws ServiceApplicationException
	 */
	private JMXConnector getJMXConnector(String serverIP, int port) throws ServiceTimeoutException {

		JMXConnector jmxConnector = null;
		try {
			CallableJMXConnector connectorCallable = new CallableJMXConnector(serverIP, port);
			ExecutorService executorService = getSingletonExecutorInstance();
			jmxConnector = executorService.submit(connectorCallable).get(RMI_TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			throw new ServiceTimeoutException(e);
		} catch (Exception e) {
			throw new ServiceApplicationException(e);
		}
		return jmxConnector;
	}

	/**
	 * This method for return JMX Bean information
	 *
	 * @param jmxObjectName
	 * @param wrapperClass
	 * @param ip
	 * @param port
	 * @return
	 */
	public ArrayList<JmxInformation> getMBeanInformation(String jmxObjectName, Class<?> wrapperClass, String ip, int port) throws ServiceApplicationException {

		ArrayList<JmxInformation> arrayList = new ArrayList<JmxInformation>();
		MBeanServerConnection mbsc = null;
		JMXConnector jmxc = null;
		try {
			jmxc = getJMXConnector(ip, port);
		} catch (Exception e) {
			throw e;
		}
		try {
			mbsc = jmxc.getMBeanServerConnection();
			Set<ObjectInstance> beans = mbsc.queryMBeans(new ObjectName(jmxObjectName), null);
			for (ObjectInstance instance : beans) {
				ObjectName objectName = instance.getObjectName();
				@SuppressWarnings("deprecation")
				JmxInformation wrapperObject = (JmxInformation) wrapperClass.newInstance();
				Hashtable<String, String> hashtable = objectName.getKeyPropertyList();
				Enumeration<String> enumeration = hashtable.keys();
				while (enumeration.hasMoreElements()) {
					try {
						String type = enumeration.nextElement();
						String value = hashtable.get(type);
						log.debug("Key :[" + type + "] Value : [" + value + "]");
						Method targetMethod = wrapperClass.getMethod("set" + toUpperCaseFirstChar(type), String.class);
						targetMethod.invoke(wrapperObject, String.valueOf(value));
					} catch (Exception e) {}
				}
				MBeanAttributeInfo[] attributeInfos = mbsc.getMBeanInfo(objectName).getAttributes();
				for (int i = 0; i < attributeInfos.length; i++) {
					try {
						String attributeName = attributeInfos[i].getName();
						String attributeType = attributeInfos[i].getType();
						Object attributeValue = mbsc.getAttribute(objectName, attributeName);
						if (attributeValue instanceof CompositeDataSupport) {
							CompositeDataSupport compositeDataSupport = (CompositeDataSupport) attributeValue;
							attributeType = CompositeDataSupport.class.getName();
							try {
								attributeValue = String.valueOf(compositeDataSupport.get("count"));
							} catch (Exception e) {
								try {
									attributeValue = String.valueOf(compositeDataSupport.get("current"));
								} catch (Exception ex) {}
							}
						}
						log.debug("Atrribute Name : [" + attributeName + "] Atrribute Type : [" + attributeType + "]  Atrribute Value : [" + attributeValue + "]");
						Class<?> classType = getPrimitiveType(attributeType);
						classType = classType == null ? Class.forName(attributeType) : classType;
						Method targetMethod = wrapperClass.getDeclaredMethod("set" + toUpperCaseFirstChar(attributeName), classType);
						targetMethod.invoke(wrapperObject, attributeValue);
					} catch (ReflectionException e) {
						log.info(e);
					} catch (Exception e) {
						log.info(e);
					}
				}
				arrayList.add(wrapperObject);
			}
		} catch (NullPointerException e) {
			log.info(e);
		} catch (Exception e) {
			throw new ServiceApplicationException("Error when get MBean " + jmxObjectName + " In Server " + ip, e);
		}
		finally {
			if (jmxc != null) {
				try {
					jmxc.close();
				} catch (IOException e) {
					//
				}
			}
		}
		return arrayList;
	}

	/**
	 * This method to return Mbeans Instances for given object name
	 *
	 * @param jmxObjectName
	 * @param ip
	 * @param port
	 * @return
	 * @throws IOException
	 * @throws MalformedObjectNameException
	 */
	public Object invokeMBean(Class<?> classInterface, String jmxObjectName, String invokedMethod, Object[] params, String ip, int port) throws ServiceApplicationException {

		Object returnObject = null;
		MBeanServerConnection mbsc = null;
		JMXConnector jmxc = null;
		try {
			jmxc = getJMXConnector(ip, port);
		} catch (Exception e) {
			throw e;
		}
		try {
			mbsc = jmxc.getMBeanServerConnection();
			Set<ObjectInstance> beans = mbsc.queryMBeans(new ObjectName(jmxObjectName), null);
			for (ObjectInstance instance : beans) {
				try {
					ObjectName objectName = instance.getObjectName();
					MBeanInfo beanInfo = mbsc.getMBeanInfo(objectName);
					if (classInterface == null) {
						Descriptor descriptor = beanInfo.getDescriptor();
						String className = (String) descriptor.getFieldValue("interfaceClassName");
						log.debug("className : " + className);
						classInterface = Class.forName(className);
					}
					Object mbeanProxy = JMX.newMBeanProxy(mbsc, objectName, classInterface, true);
					Method[] methods = classInterface.getMethods();
					if (mbeanProxy != null) {
						for (int i = 0; i < methods.length; i++) {
							if (invokedMethod.equalsIgnoreCase(methods[i].getName())) {
								returnObject = methods[i].invoke(mbeanProxy, params);
							}
						}
					}
				} catch (Exception e) {
					log.info(e);
				}
			}
		} catch (NullPointerException e) {} catch (Exception e) {
			throw new ServiceApplicationException("Error when Execute method " + invokedMethod + " with param " + params + " In Server " + ip, e);
		}
		finally {
			if (jmxc != null) {
				try {
					jmxc.close();
				} catch (IOException e) {
					//
				}
			}
		}
		return returnObject;
	}

	/**
	 *
	 * @param mbeanName
	 * @param functionName
	 * @param prams
	 * @param ip
	 * @param port
	 * @return
	 */
	public Object invokeMBean(String mbeanName, String functionName, Object[] prams, String ip, int port) {

		return invokeMBean(null, mbeanName, functionName, prams, ip, port);
	}
}