package com.istnet.stc.integ.jmx.ivr;

import com.icsp.integ.db.exception.ServiceExceptionFactory;
import com.istnet.stc.integ.jmx.JmxProvider;

import java.util.ArrayList;

public class Ivr extends JmxProvider {

	public static final String	MBEAN_QUERY_CVP		= "Cisco Unified CVP VXML Server Application Management API:scope=Global,group=Command";
	public static final String	MBEAN_QUERY_ISD		= "ivr:Name=ScriptLoader,Type=ScriptLoader";
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public Ivr(String ip, int port) {

		super(ip, port);
	}

	public Object callFunction(int ivrType, String functionName, Object... prams) throws ServiceExceptionFactory {

		Object theReturn = null;
		switch (ivrType) {
			case 1:
				theReturn = super.callFunction(MBEAN_QUERY_ISD, functionName, prams);
				break;
			case 2:
				theReturn = super.callFunction(MBEAN_QUERY_CVP, functionName, prams);
				break;
		}
		return theReturn;
	}

	public ArrayList<?> getInformation(int ivrType) throws ServiceExceptionFactory {

		ArrayList<?> theReturn = null;
		switch (ivrType) {
			case 1:
				theReturn = super.getInformation(MBEAN_QUERY_ISD, IvrInformation.class);
				break;
			case 2:
				theReturn = super.getInformation(MBEAN_QUERY_CVP, IvrInformation.class);
				break;
		}
		return theReturn;
	}
}