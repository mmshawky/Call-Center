/**
 *
 */
package com.icsp.ivr.agi.callflow.node.decision;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.callflow.node.PbxNode;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky
 */
public abstract class PbxDecision extends PbxNode {

	private String	unmatchTargetNode;

	/**
	 * @param manager
	 *
	 */
	public PbxDecision(AgiChannel channel, PbxNodesManager manager, String id, String matchTargetNode, String unmatchTargetNode, PbxMedia... prompts) {

		super(channel, manager, id, matchTargetNode, prompts);
		this.unmatchTargetNode = unmatchTargetNode;
	}

	@Override
	public Object construct() throws FastAgiException {

		try {
			if (!match()) {
				targetNode = unmatchTargetNode;
			}
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
		return targetNode;
	}

	public abstract boolean match();
}