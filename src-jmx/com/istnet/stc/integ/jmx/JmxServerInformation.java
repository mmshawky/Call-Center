/**
 *
 */
package com.istnet.stc.integ.jmx;

import com.icsp.integ.db.exception.ServiceExceptionFactory;
import com.istnet.stc.integ.jmx.database.DBGFInformation;
import com.istnet.stc.integ.jmx.database.DBInformation;
import com.istnet.stc.integ.jmx.database.Database;
import com.istnet.stc.integ.jmx.database.DatabaseGF;
import com.istnet.stc.integ.jmx.lang.Memory;
import com.istnet.stc.integ.jmx.lang.MemoryInformation;
import com.istnet.stc.integ.jmx.lang.OperatingSystem;
import com.istnet.stc.integ.jmx.lang.OperatingSystemInformation;
import com.istnet.stc.integ.jmx.lang.RuntimeInformation;
import com.istnet.stc.integ.jmx.lang.Threading;
import com.istnet.stc.integ.jmx.lang.ThreadingInformation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mostafa M.Shawky
 *
 */
public class JmxServerInformation implements Serializable {

	/**
	 *
	 */
	private static final long						serialVersionUID			= 1L;
	private ArrayList<DBGFInformation>				dbgfInformations			= new ArrayList<DBGFInformation>();
	private ArrayList<DBInformation>				dbInformations				= new ArrayList<DBInformation>();
	private String									ip;
	private ArrayList<MemoryInformation>			memoryInformations			= new ArrayList<MemoryInformation>();
	private ArrayList<OperatingSystemInformation>	operatingSystemInformations	= new ArrayList<OperatingSystemInformation>();
	private int										port;
	private ArrayList<RuntimeInformation>			runtimeInformations			= new ArrayList<RuntimeInformation>();
	private ArrayList<ThreadingInformation>			threadingInformations		= new ArrayList<ThreadingInformation>();

	public JmxServerInformation() {

		super();
	}

	/**
	 *
	 */
	public JmxServerInformation(String ip, int port) {

		this.ip = ip;
		this.port = port;
	}

	public ArrayList<DBGFInformation> getDbgfInformations() throws ServiceExceptionFactory {

		DatabaseGF database = new DatabaseGF(ip, port);
		for (JmxInformation jmxInformation : (database.getInformation())) {
			this.dbgfInformations.add((DBGFInformation) jmxInformation);
		}
		return dbgfInformations;
	}

	/**
	 * @return the connectionInformations
	 * @throws ServiceExceptionFactory
	 */
	public ArrayList<DBInformation> getDbInformations() throws ServiceExceptionFactory {

		Database database = new Database(ip, port);
		for (JmxInformation jmxInformation : (database.getInformation())) {
			this.dbInformations.add((DBInformation) jmxInformation);
		}
		return dbInformations;
	}

	/**
	 * @return the memoryInformations
	 * @throws ServiceExceptionFactory
	 */
	@SuppressWarnings ("unchecked")
	public ArrayList<MemoryInformation> getMemoryInformations() throws ServiceExceptionFactory {

		Memory memory = new Memory(ip, port);
		for (JmxInformation jmxInformation : ((ArrayList<JmxInformation>) memory.getInformation())) {
			this.memoryInformations.add((MemoryInformation) jmxInformation);
		}
		return memoryInformations;
	}

	/**
	 * @return the operatingSystemInformations
	 * @throws ServiceExceptionFactory
	 */
	@SuppressWarnings ("unchecked")
	public ArrayList<OperatingSystemInformation> getOperatingSystemInformations() throws ServiceExceptionFactory {

		OperatingSystem operatingSystem = new OperatingSystem(ip, port);
		for (JmxInformation jmxInformation : ((ArrayList<JmxInformation>) operatingSystem.getInformation())) {
			this.operatingSystemInformations.add((OperatingSystemInformation) jmxInformation);
		}
		return operatingSystemInformations;
	}

	/**
	 * @return the runtimeInformations
	 * @throws ServiceExceptionFactory
	 */
	@SuppressWarnings ("unchecked")
	public ArrayList<RuntimeInformation> getRuntimeInformations() throws ServiceExceptionFactory {

		com.istnet.stc.integ.jmx.lang.Runtime runtime = new com.istnet.stc.integ.jmx.lang.Runtime(ip, port);
		for (JmxInformation jmxInformation : ((ArrayList<JmxInformation>) runtime.getInformation())) {
			this.runtimeInformations.add((RuntimeInformation) jmxInformation);
		}
		return runtimeInformations;
	}

	/**
	 * @return the ThreadingInformation
	 * @throws ServiceExceptionFactory
	 */
	@SuppressWarnings ("unchecked")
	public ArrayList<ThreadingInformation> getThreadingInformations() throws ServiceExceptionFactory {

		Threading threading = new Threading(ip, port);
		for (JmxInformation jmxInformation : ((ArrayList<JmxInformation>) threading.getInformation())) {
			this.threadingInformations.add((ThreadingInformation) jmxInformation);
		}
		return threadingInformations;
	}

	/**
	 * @param connectionInformations
	 *            the connectionInformations to set
	 */
	public void setDbgfInformations(ArrayList<DBGFInformation> dbgfInformations) {

		this.dbgfInformations = dbgfInformations;
	}

	/**
	 * @param connectionInformations
	 *            the connectionInformations to set
	 */
	public void setDbInformations(ArrayList<DBInformation> dbInformations) {

		this.dbInformations = dbInformations;
	}

	/**
	 * @param memoryInformations
	 *            the memoryInformations to set
	 */
	public void setMemoryInformations(ArrayList<MemoryInformation> memoryInformations) {

		this.memoryInformations = memoryInformations;
	}

	/**
	 * @param operatingSystemInformations
	 *            the operatingSystemInformations to set
	 */
	public void setOperatingSystemInformations(ArrayList<OperatingSystemInformation> operatingSystemInformations) {

		this.operatingSystemInformations = operatingSystemInformations;
	}

	/**
	 * @param runtimeInformations
	 *            the runtimeInformations to set
	 */
	public void setRuntimeInformations(ArrayList<RuntimeInformation> runtimeInformations) {

		this.runtimeInformations = runtimeInformations;
	}

	/**
	 * @param ThreadingInformation
	 *            the ThreadingInformation to set
	 */
	public void setThreadingInformations(ArrayList<ThreadingInformation> threadingInformations) {

		this.threadingInformations = threadingInformations;
	}
}