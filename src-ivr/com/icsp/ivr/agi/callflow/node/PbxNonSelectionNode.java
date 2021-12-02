/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.ivr.util.Constants.INPUT_TIMEOUT;
import static com.icsp.ivr.util.Constants.MAX_INVALID_INPUT;
import static com.icsp.ivr.util.Constants.MAX_NO_INPUT;
import static com.icsp.ivr.util.Constants.MILLISECOND;

import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky
 */
public abstract class PbxNonSelectionNode extends PbxNode {

	private int	inputTimeout	= INPUT_TIMEOUT * MILLISECOND;
	private int	maxInvalidInput	= MAX_INVALID_INPUT;
	private int	maxNoInput		= MAX_NO_INPUT;

	/**
	 * @param manager
	 *            TODO
	 */
	public PbxNonSelectionNode(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia... prompts) {

		super(channel, manager, id, targetNode, prompts);
	}

	/**
	 * This method for get inputTimeout
	 *
	 * @return the inputTimeout
	 */
	public int getInputTimeout() {

		return inputTimeout;
	}

	/**
	 * This method for get maxInvalidInput
	 *
	 * @return the maxInvalidInput
	 */
	public int getMaxInvalidInput() {

		return maxInvalidInput;
	}

	/**
	 * This method for get maxNoInput
	 *
	 * @return the maxNoInput
	 */
	public int getMaxNoInput() {

		return maxNoInput;
	}

	/**
	 * This method for set inputTimeout
	 *
	 * @param inputTimeout
	 *            the inputTimeout to set
	 */
	public void setInputTimeout(int inputTimeout) {

		this.inputTimeout = inputTimeout;
	}

	/**
	 * This method for set maxInvalidInput
	 *
	 * @param maxInvalidInput
	 *            the maxInvalidInput to set
	 */
	public void setMaxInvalidInput(int maxInvalidInput) {

		this.maxInvalidInput = maxInvalidInput;
	}

	/**
	 * This method for set maxNoInput
	 *
	 * @param maxNoInput
	 *            the maxNoInput to set
	 */
	public void setMaxNoInput(int maxNoInput) {

		this.maxNoInput = maxNoInput;
	}
}