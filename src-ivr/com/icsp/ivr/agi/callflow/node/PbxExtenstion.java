/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Apr 12, 2013 10:14:43 PM
 */
public class PbxExtenstion extends PbxTransfeer {

	/**
	 * @param channel
	 * @param manager
	 * @param id
	 * @param targetNode
	 * @param prompts
	 */
	public PbxExtenstion(AgiChannel channel, PbxNodesManager manager, String id, String extension, PbxMedia... prompts) {

		super(channel, manager, id, null, prompts);
		setExtension(extension);
	}
}