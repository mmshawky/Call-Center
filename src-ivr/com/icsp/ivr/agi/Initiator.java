/**
 *
 */
package com.icsp.ivr.agi;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.integ.binder.JAXBinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Mostafa M.Shawky
 */
public class Initiator {
	
	private static FileInputStream	in;
	static {
		try {
			in = new FileInputStream(new File("D:\\eclipse-workspace\\CustomAsteriskAGI\\settings\\fastagi.xml"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This method for start Asterisk AGI Server
	 *
	 * @param args
	 * @throws IOException
	 * @throws IllegalStateException
	 */
//	public static void main(String[] args) throws IllegalStateException, IOException {
//	
//		new Initiator();
//	}
	
	public static void main(String[] args) {
		new Initiator();
	}
	
	/**
	 *
	 */
	public Initiator() {
	
		super();
		try {
			Class<?>[] tobepound = { FastAgiServer.class, FastAgiScript.class, XMLMappingStrategy.class };
			FastAgiServer server = (FastAgiServer) JAXBinder.unmarshall(in, tobepound);
			server.startup();
		} catch (IllegalStateException e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		} catch (IOException e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		} catch (Exception e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
	}
}