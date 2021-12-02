/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import java.sql.Timestamp;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;

/**
 * @author Mostafa M.Shawky
 *         Apr 28, 2015 10:20:17 PM
 *
 */
public abstract class PbxNode {

	private Logger				logger		= Logger.getLogger(getClass());
	protected boolean			isEnabled	= true;
	protected AgiChannel		channel;
	protected Timestamp			dateEnd;
	protected Timestamp			dateStart;
	protected long				duration;
	protected String			endCallReason;
	protected String			escapeDigits;
	protected String			id;
	protected PbxNodesManager	manager;
	protected PbxModulator		modulator;
	protected PbxMedia[]		prompts;
	protected String			targetNode;
	protected String			uniqueId;

	/**
	 * @param manager
	 * @throws AgiException
	 */
	public PbxNode(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia... prompts) {

		this.channel = channel;
		this.id = id;
		this.prompts = prompts;
		this.targetNode = targetNode;
		this.manager = manager;
		this.uniqueId = channel.getUniqueId();
		this.endCallReason = channel.getLastReply().getFirstLine();
		manager.addNode(this.getId(), this);
	}

	/*
	 * This method for construct the node and should over ride by developer
	 */
	protected abstract Object construct() throws FastAgiException;

	/**
	 * @throws AgiException
	 */
	public void play() throws FastAgiException {

		try {
			long startMiSec = Calendar.getInstance().getTime().getTime();
			this.dateStart = new Timestamp(startMiSec);
			PbxModulator pbxModulator = getModulator();
			logger.debug("Is there modulator " + pbxModulator);
			if (pbxModulator != null) {
				pbxModulator.enterNode(this);
			}
			logger.debug("Will Strat build");
			logger.debug(">>> " + construct());
			if (pbxModulator != null) {
				pbxModulator.exitNode(this);
			}
			long endMiSec = Calendar.getInstance().getTime().getTime();
			this.dateEnd = new Timestamp(endMiSec);
			this.duration = endMiSec - startMiSec;
			manager.addToCallHistory(this);
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
	}

	/**
	 * This method add Modulator to Pbx Node to be able to do some logic
	 *
	 * @param modulator
	 */
	public void addModulator(PbxModulator modulator) {

		setModulator(modulator);
	}

	public Timestamp getDateEnd() {

		return dateEnd;
	}

	public Timestamp getDateStart() {

		return dateStart;
	}

	public long getDuration() {

		return duration;
	}

	public String getEndCallReason() {

		return endCallReason;
	}

	/**
	 * @return the escapeDigits
	 */
	public String getEscapeDigits() {

		return escapeDigits;
	}

	/**
	 * @return the id
	 */
	public String getId() {

		return id;
	}

	public PbxNodesManager getManager() {

		return manager;
	}

	/**
	 * This method for get modulator
	 *
	 * @return the modulator
	 */
	public PbxModulator getModulator() {

		return modulator;
	}

	/**
	 * @return the prompts
	 */
	public PbxMedia[] getPrompts() {

		return prompts;
	}

	/**
	 * @return the targetNode
	 */
	public String getTargetNode() {

		return targetNode;
	}

	public String getUniqueId() {

		return uniqueId;
	}

	/**
	 * @return the isEnabled
	 */
	public boolean isEnabled() {

		return isEnabled;
	}

	public void setDateEnd(Timestamp dateEnd) {

		this.dateEnd = dateEnd;
	}

	public void setDateStart(Timestamp dateStart) {

		this.dateStart = dateStart;
	}

	public void setDuration(long duration) {

		this.duration = duration;
	}

	/**
	 * @param isEnabled
	 *            the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {

		this.isEnabled = isEnabled;
	}

	public void setEndCallReason(String endCallReason) {

		this.endCallReason = endCallReason;
	}

	/**
	 * @param escapeDigits
	 *            the escapeDigits to set
	 */
	public void setEscapeDigits(String escapeDigits) {

		this.escapeDigits = escapeDigits;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {

		this.id = id;
	}

	/**
	 * This method for set modulator
	 *
	 * @param modulator
	 *            the modulator to set
	 */
	public void setModulator(PbxModulator modulator) {

		this.modulator = modulator;
	}

	/**
	 * @param prompts
	 *            the prompts to set
	 */
	public void setPrompts(PbxMedia[] prompts) {

		this.prompts = prompts;
	}

	/**
	 * @param targetNode
	 *            the targetNode to set
	 */
	public void setTargetNode(String targetNode) {

		this.targetNode = targetNode;
	}

	public void setUniqueId(String uniqueId) {

		this.uniqueId = uniqueId;
	}
}