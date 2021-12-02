/**
 *
 */
package com.icsp.ivr.agi.callflow.media;

import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author
 */
public class PbxPrompt extends PbxMedia {
	
	/**
	 *
	 */
	public PbxPrompt(AgiChannel channel, PbxNodesManager manager, String prompt) {
	
		super(channel, manager, prompt);
	}
}