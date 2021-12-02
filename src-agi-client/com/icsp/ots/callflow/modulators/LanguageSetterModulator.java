/**
 *
 */
package com.icsp.ots.callflow.modulators;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.node.PbxMenu;
import com.icsp.ivr.agi.callflow.node.PbxModulator;
import com.icsp.ivr.agi.callflow.node.PbxNode;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.util.Language;

import org.apache.log4j.Logger;

/**
 * @author Mostafa M.Shawky Nov 17, 2013 9:19:38 PM
 */
public class LanguageSetterModulator implements PbxModulator {
	
	Logger	logger	= Logger.getLogger(getClass());
	
	/**
	 *
	 */
	public LanguageSetterModulator() {
	
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
	
		PbxMenu menu = (PbxMenu) pbxNode;
		PbxNodesManager manager = menu.getManager();
		CallFlowData data = manager.getCallFlowData();
		String selectedOption = menu.getSelectedOption();
		logger.debug("Selected Option is [" + selectedOption + "]");
		try {
			if ("2".equalsIgnoreCase(selectedOption)) {
				data.setCallLanguage(Language.En);
			} else {
				data.setCallLanguage(Language.Ar);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}
}