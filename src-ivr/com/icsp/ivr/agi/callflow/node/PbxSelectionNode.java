/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.ivr.util.Constants.MAX_INVALID_SELECTION;
import static com.icsp.ivr.util.Constants.MAX_NO_SELECTION;
import static com.icsp.ivr.util.Constants.MILLISECOND;
import static com.icsp.ivr.util.Constants.PRESS_TIMEOUT;

import com.icsp.ivr.agi.callflow.media.PbxMedia;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author
 */
public abstract class PbxSelectionNode extends PbxNode {

	private int		maxInvalidSelection	= MAX_INVALID_SELECTION;
	private int		maxNoSelection		= MAX_NO_SELECTION;
	private int		pressTimout			= PRESS_TIMEOUT * MILLISECOND;
	private String	selectedOption;

	/**
	 * @param manager
	 *            TODO
	 *
	 */
	public PbxSelectionNode(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia[] prompts) {

		super(channel, manager, id, targetNode, prompts);
	}

	/**
	 * @return the maxInvalidSelection
	 */
	public int getMaxInvalidSelection() {

		return maxInvalidSelection;
	}

	/**
	 * @return the maxNoSelection
	 */
	public int getMaxNoSelection() {

		return maxNoSelection;
	}

	/**
	 * @return the pressTimout
	 */
	public int getPressTimout() {

		return pressTimout;
	}

	/**
	 * @return the selectedOption
	 */
	public String getSelectedOption() {

		return selectedOption;
	}

	/**
	 * @param maxInvalidSelection
	 *            the maxInvalidSelection to set
	 */
	public void setMaxInvalidSelection(int maxInvalidSelection) {

		this.maxInvalidSelection = maxInvalidSelection;
	}

	/**
	 * @param maxNoSelection
	 *            the maxNoSelection to set
	 */
	public void setMaxNoSelection(int maxNoSelection) {

		this.maxNoSelection = maxNoSelection;
	}

	/**
	 * @param pressTimout
	 *            the pressTimout to set
	 */
	public void setPressTimout(int pressTimout) {

		this.pressTimout = pressTimout * MILLISECOND;
	}

	/**
	 * @param selectedOption
	 *            the selectedOption to set
	 */
	public void setSelectedOption(String selectedOption) {

		this.selectedOption = selectedOption;
	}
}