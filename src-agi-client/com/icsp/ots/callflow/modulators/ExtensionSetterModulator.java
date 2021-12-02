/**
 *
 */
package com.icsp.ots.callflow.modulators;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.node.PbxInput;
import com.icsp.ivr.agi.callflow.node.PbxModulator;
import com.icsp.ivr.agi.callflow.node.PbxNode;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

import org.apache.log4j.Logger;

/**
 * @author Mostafa M.Shawky Nov 17, 2013 9:19:38 PM
 */
public class ExtensionSetterModulator implements PbxModulator {

	Logger	logger	= Logger.getLogger(getClass());

	/**
	 *
	 */
	public ExtensionSetterModulator() {

		super();
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.icsp.ivr.agi.callflow.node.PbxModulator#enterNode(com.icsp.ivr.agi.callflow
	 * .node.PbxNode)
	 */
	@Override
	public void enterNode(PbxNode pbxNode) {

	}

	/*
	 * (non-Javadoc)
	 * @see
	 * com.icsp.ivr.agi.callflow.node.PbxModulator#exitNode(com.icsp.ivr.agi.callflow
	 * .node.PbxNode)
	 */
	@Override
	public void exitNode(PbxNode pbxNode) {

		PbxInput input = (PbxInput) pbxNode;
		PbxNodesManager manager = input.getManager();
		CallFlowData data = manager.getCallFlowData();
		String userInput = input.getUserInput();
		logger.debug("User Input is [" + userInput + "]");
		try {
			if ((userInput != null) && (!userInput.isEmpty())) {
				if (userInput.startsWith("0")) {
					input.setTargetNode("AssistanceExtension");
				} else if (userInput.indexOf("timeout") == -1) {
					data.setTargetExtension(userInput);
					input.setTargetNode("SelectedExtension");
				}
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}