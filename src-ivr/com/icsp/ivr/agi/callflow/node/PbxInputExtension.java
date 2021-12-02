/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Mar 29, 2013 1:54:12 PM
 */
public class PbxInputExtension extends PbxInput {

	private Logger	logger	= Logger.getLogger(getClass());

	/**
	 * @param manager
	 */
	public PbxInputExtension(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia prompt) {

		super(channel, manager, id, targetNode, prompt);
	}

	/**
	 *
	 */
	@Override
	protected Object construct() throws FastAgiException {

		try {
			String userInputExtension = (String) super.construct();
			if ((userInputExtension != null) && (!userInputExtension.isEmpty())) {
				CallFlowData callFlowData = manager.getCallFlowData();
				callFlowData.setTargetExtension(userInputExtension);
				logger.debug("Extension input is [" + userInputExtension + "]");
			}
		} catch (Exception e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			throw new FastAgiException(e);
		}
		return null;
	}
}