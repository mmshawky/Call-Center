/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Apr 12, 2013 10:14:43 PM
 */
public class PbxAgent extends PbxExtenstion {

	/**
	 * @param channel
	 * @param manager
	 * @param id
	 * @param targetNode
	 * @param prompts
	 */
	public PbxAgent(AgiChannel channel, PbxNodesManager manager, String id, String queueId, PbxMedia... prompts) {

		super(channel, manager, id, null, prompts);
		setExtension(queueId);
	}
}