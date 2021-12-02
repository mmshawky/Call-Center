/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Apr 12, 2013 10:14:43 PM
 */
public class PbxTransfeer extends PbxOutput {

	protected String	extension;
	private Logger		logger	= Logger.getLogger(getClass());

	/**
	 * @param channel
	 * @param manager
	 * @param id
	 * @param targetNode
	 * @param prompts
	 */
	public PbxTransfeer(AgiChannel channel, PbxNodesManager manager, String id, String extension, PbxMedia... prompts) {

		super(channel, manager, id, null, prompts);
		this.extension = extension;
	}

	@Override
	public Object construct() throws FastAgiException {

		try {
			super.construct();
			CallFlowData callFlowData = manager.getCallFlowData();
			String inputEx = callFlowData.getTargetExtension();
			extension = extension == null ? inputEx : extension;
			logger.debug("Extension to transfare [" + extension + "]");
			channel.setExtension(extension);
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
		return extension;
	}

	public String getExtension() {

		return extension;
	}

	public void setExtension(String extension) {

		this.extension = extension;
	}
}