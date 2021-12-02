/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.callflow.media.PbxPromptDigit;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Mar 29, 2013 1:54:12 PM
 */
public class PbxInputWithConfirm extends PbxInput {

	private PbxMedia		confirmPrompt;
	private PbxMenuTemplate	menuTemplate;

	/**
	 * @param manager
	 *            TODO
	 */
	public PbxInputWithConfirm(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia prompt, PbxMedia confirmPrompt, PbxMenuTemplate menuTemplate) {

		super(channel, manager, id, targetNode, prompt);
		this.confirmPrompt = confirmPrompt;
		this.menuTemplate = menuTemplate;
	}

	/*
	 * (non-Javadoc)
	 * @see com.holol.agi.node.PbxNode#build()
	 */
	@Override
	protected Object construct() throws FastAgiException {

		try {
			String input = (String) super.construct();
			if (input != null) {
				PbxOutput enteredDigits = new PbxOutput(channel, manager, "EnteredDigits", targetNode, confirmPrompt);
				enteredDigits.play();
							
				PbxPromptDigit [] promptDigits = manager.createPbxPromptDigits(input);
				PbxOutput output = new PbxOutput(channel, manager, "Digits", targetNode, promptDigits);
				output.play();
				if (menuTemplate != null) {
					menuTemplate.play();
					if (menuTemplate.getTargetNode() != null) {
						setTargetNode(menuTemplate.getTargetNode());
					}
				}
			}
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
		return input;
	}
}