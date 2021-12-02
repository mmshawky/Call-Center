/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

/**
 * @author Mostafa M.Shawky
 *         Apr 28, 2015 10:22:00 PM
 *
 */
public interface PbxModulator {

	public abstract void enterNode(PbxNode pbxNode);

	public abstract void exitNode(PbxNode pbxNode);
}