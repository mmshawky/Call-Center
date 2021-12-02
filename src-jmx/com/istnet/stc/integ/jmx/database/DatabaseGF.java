/**
 *
 */
package com.istnet.stc.integ.jmx.database;

import com.icsp.integ.exception.ServiceApplicationException;
import com.istnet.stc.integ.jmx.JmxInformation;
import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Mostafa M.Shawky
 *
 */
public class DatabaseGF extends JmxProvider {

	public static final String	GF_MBEAN_QUERY_DATASOURCE_MON		= "amx:pp=/mon/server-mon[server],type=jdbc-connection-pool-mon,name=resources/*";
	public static final String	GF_MBEAN_QUERY_DATASOURCE_SETTING	= "amx:pp=/domain/resources,type=jdbc-connection-pool,name=*";
	/**
	 *
	 */
	private static final long	serialVersionUID					= 1L;

	/**
	 *
	 */
	public DatabaseGF(String ip, int port) {

		super(ip, port);
	}

	public Object callFunction(String functionName, Object... prams) throws ServiceApplicationException {

		return super.callFunction(GF_MBEAN_QUERY_DATASOURCE_SETTING, functionName, prams);
	}

	/**
	 * This method for do action according to given action and JMX query
	 *
	 * @param databaseName
	 * @param action
	 * @throws ServiceExceptionFactory
	 */
	public ArrayList<JmxInformation> getInformation() throws ServiceApplicationException {

		HashMap<String, JmxInformation> table = new HashMap<>();
		ArrayList<JmxInformation> gfConnectionInformations = super.getInformation(GF_MBEAN_QUERY_DATASOURCE_SETTING, DBGFInformation.class);
		for (JmxInformation jmxInformation : gfConnectionInformations) {
			DBGFInformation gfConnectionInformation = (DBGFInformation) jmxInformation;
			table.put(gfConnectionInformation.getName(), gfConnectionInformation);
		}
		gfConnectionInformations = super.getInformation(GF_MBEAN_QUERY_DATASOURCE_MON, DBGFInformation.class);
		for (JmxInformation jmxInformation : gfConnectionInformations) {
			DBGFInformation gfConnectionInformation = (DBGFInformation) jmxInformation;
			String key = gfConnectionInformation.getName().substring(gfConnectionInformation.getName().indexOf("/") + 1);
			DBGFInformation storedOne = (DBGFInformation) table.get(key);
			storedOne.setNumpotentialconnleak(gfConnectionInformation.getNumpotentialconnleak());
			storedOne.setNumconnsuccessfullymatched(gfConnectionInformation.getNumconnsuccessfullymatched());
			storedOne.setNumconnreleased(gfConnectionInformation.getNumconnreleased());
			storedOne.setNumpotentialconnleak(gfConnectionInformation.getNumpotentialconnleak());
			storedOne.setNumconnfailedvalidation(gfConnectionInformation.getNumconnfailedvalidation());
			storedOne.setWaitqueuelength(gfConnectionInformation.getWaitqueuelength());
			storedOne.setNumconnfree(gfConnectionInformation.getNumconnfree());
			storedOne.setConnrequestwaittime(gfConnectionInformation.getConnrequestwaittime());
			storedOne.setNumconnused(gfConnectionInformation.getNumconnused());
			storedOne.setNumconndestroyed(gfConnectionInformation.getNumconndestroyed());
			storedOne.setNumconnacquired(gfConnectionInformation.getNumconnacquired());
			storedOne.setAverageconnwaittime(gfConnectionInformation.getAverageconnwaittime());
			storedOne.setNumconnacquired(gfConnectionInformation.getNumconntimedout());
			storedOne.setNumconnnotsuccessfullymatched(gfConnectionInformation.getNumconnnotsuccessfullymatched());
			storedOne.setNumconncreated(gfConnectionInformation.getNumconncreated());
		}
		ArrayList<JmxInformation> retruns = new ArrayList<>();
		for (JmxInformation jmxInformation : table.values()) {
			retruns.add(jmxInformation);
		}
		return retruns;
	}
}