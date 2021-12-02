/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky Mar 31, 2013 2:21:14 AM
 */
public class PbxMenuTemplate extends PbxMenu {

	/**
	 * @param channel
	 * @param manager
	 *            TODO
	 * @param id
	 * @param targetNode
	 * @param prompts
	 */
	public PbxMenuTemplate(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia[] prompts) {

		super(channel, manager, id, targetNode, prompts);
	}
}