/**
 *
 */
package com.icsp.ivr.agi.callflow.media;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author
 */
public class PbxMedia {
	
	protected AgiChannel		channel;
	protected String			index;
	protected boolean			isInterrupted	= true;
	protected PbxNodesManager	manager;
	protected String			name;
	protected String			prompt;
	protected String			pauseDigit;
	protected String			uniqueId;
	
	/**
	 *
	 */
	public PbxMedia(AgiChannel channel, PbxNodesManager manager, String prompt) {
	
		// this(prompt);
		this.channel = channel;
		this.manager = manager;
		this.prompt = prompt;
		this.uniqueId = channel.getUniqueId();
	}
	
	// public PbxMedia(String prompt) {
	//
	// super();
	// this.prompt = prompt;
	// }
	/**
	 * This method for get channel
	 *
	 * @return the channel
	 */
	public AgiChannel getChannel() {
	
		return channel;
	}
	
	/**
	 * @return the index
	 */
	protected String getIndex() {
	
		return index;
	}
	
	/**
	 * @return the name
	 */
	protected String getName() {
	
		return name;
	}
	
	/**
	 * @return the prompt
	 */
	public String getPath() {
	
		CallFlowData data = manager.getCallFlowData();
		String promptPath = data.getPromptPath();
		return promptPath + prompt;
	}
	
	/**
	 * @return the pauseDigit
	 */
	public String getPauseDigit() {
	
		return pauseDigit;
	}
	
	public String getUniqueId() {
	
		return uniqueId;
	}
	
	/**
	 * @return the isInterrupted
	 */
	public boolean isInterrupted() {
	
		return isInterrupted;
	}
	
	/**
	 * This method for set channel
	 *
	 * @param channel
	 *            the channel to set
	 */
	public void setChannel(AgiChannel channel) {
	
		this.channel = channel;
	}
	
	/**
	 * @param index
	 *            the index to set
	 */
	public void setIndex(String index) {
	
		this.index = index;
	}
	
	/**
	 * @param isInterrupted
	 *            the isInterrupted to set
	 */
	public void setInterrupted(boolean isInterrupted) {
	
		this.isInterrupted = isInterrupted;
	}
	
	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
	
		this.name = name;
	}
	
	/**
	 * @param prompt
	 *            the prompt to set
	 */
	public void setPath(String path) {
	
		this.prompt = path;
	}
	
	/**
	 * @param pauseDigit
	 *            the pauseDigit to set
	 */
	public void setPauseDigit(String pauseDigit) {
	
		this.pauseDigit = pauseDigit;
	}
	
	public void setUniqueId(String uniqueId) {
	
		this.uniqueId = uniqueId;
	}
	
	/**
	 * @return the prompt
	 */
	public String getPrompt() {
	
		return prompt;
	}
	
	/**
	 * @param prompt
	 *            the prompt to set
	 */
	public void setPrompt(String prompt) {
	
		this.prompt = prompt;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	
		return "PbxMedia [channel=" + channel + ", index=" + index + ", isInterrupted=" + isInterrupted + ", manager=" + manager + ", name=" + name + ", prompt=" + prompt
			+ ", pauseDigit=" + pauseDigit + ", uniqueId=" + uniqueId + ", getPath()=" + getPath() + ", getPauseDigit()=" + getPauseDigit() + ", getUniqueId()=" + getUniqueId()
			+ ", isInterrupted()=" + isInterrupted() + ", getPrompt()=" + getPrompt() + "]";
	}
	//
	// @Override
	// public String toString() {
	//
	// return "PbxMedia [Name: " + getName() + ", Path: " + getPath() + "]";
	// }
}