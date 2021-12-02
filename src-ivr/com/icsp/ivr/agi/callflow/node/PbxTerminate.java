/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.event.PbxTerminationEvent;
import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Apr 12, 2013 9:39:51 PM
 */
public class PbxTerminate extends PbxNode {
	
	/**
	 * @param channel
	 * @param manager
	 * @param id
	 * @param targetNode
	 * @param prompts
	 */
	public PbxTerminate(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia... prompts) {
	
		super(channel, manager, id, targetNode, prompts);
	}
	
	@Override
	public Object construct() throws PbxTerminationEvent {
	
		try {
			channel.hangup();
		} catch (Exception e) {
			throw new PbxTerminationEvent();
		}
		return null;
	}
}