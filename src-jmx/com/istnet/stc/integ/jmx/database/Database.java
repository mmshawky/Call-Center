/**
 *
 */
package com.istnet.stc.integ.jmx.database;

import com.icsp.integ.exception.ServiceApplicationException;
import com.istnet.stc.integ.jmx.JmxInformation;
import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;

/**
 * @author Mostafa M.Shawky
 *
 */
public class Database extends JmxProvider {

	public static final String	GF_MBEAN_QUERY_DATASOURCE_MON		= "amx:pp=/mon/server-mon[server],type=jdbc-connection-pool-mon,name=resources/*";
	public static final String	GF_MBEAN_QUERY_DATASOURCE_SETTING	= "amx:pp=/domain/resources,type=jdbc-connection-pool,name=*";
	public static final String	MBEAN_QUERY_CONNECTIVITY			= "UCC:Name=Database,Type=Connectivity";
	// public static final String MBEAN_QUERY_DATASOURCE =
	// "Catalina:type=DataSource,context=/ivr,host=localhost,class=javax.sql.DataSource,*";
	public static final String	MBEAN_QUERY_DATASOURCE				= "Catalina:type=DataSource,*";
	/**
	 *
	 */
	private static final long	serialVersionUID					= 1L;

	/**
	 *
	 */
	public Database(String ip, int port) {

		super(ip, port);
	}

	/**
	 * This method for do action according to given action and JMX query
	 *
	 * @param databaseName
	 * @param action
	 * @throws ServiceExceptionFactory
	 */
	public Object callFunction(String functionName, Object... prams) throws ServiceApplicationException {

		return super.callFunction(MBEAN_QUERY_CONNECTIVITY, functionName, prams);
	}

	/**
	 * This method for return JMX Bean information
	 *
	 * @throws ServiceExceptionFactory
	 */
	public ArrayList<JmxInformation> getInformation() throws ServiceApplicationException {

		return super.getInformation(MBEAN_QUERY_DATASOURCE, DBInformation.class);
	}
}