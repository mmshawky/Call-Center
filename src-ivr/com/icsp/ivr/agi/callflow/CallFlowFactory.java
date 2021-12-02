/**
 *
 */
package com.icsp.ivr.agi.callflow;

import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

/**
 * @author Mostafa M.Shawky
 *         Apr 29, 2015 12:09:35 AM
 *
 */
public interface CallFlowFactory {
	
	void initCallFlow(PbxNodesManager manager);
}