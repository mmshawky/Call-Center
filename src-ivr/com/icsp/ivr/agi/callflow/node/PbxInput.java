/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_SHORT_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;

/**
 * @author Mostafa M.Shawky Mar 29, 2013 1:54:12 PM
 */
public class PbxInput extends PbxNonSelectionNode {

	private final Logger	logger		= Logger.getLogger(getClass());
	private final String	TIMEOUT		= "(timeout)";
	protected int			maxEntered	= 100;
	protected int			minEntered	= 1;
	protected String		input;
	private PbxMedia		invalidInputPrompt;
	private String			invalidInputURI;
	private PbxMedia		noInputPrompt;
	private String			noInputURI;
	protected String		pattern;
	private String			userInput;

	/**
	 * @param manager
	 */
	public PbxInput(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia prompt) {

		super(channel, manager, id, targetNode, prompt);
	}

	/*
	 * (non-Javadoc)
	 * @see com.holol.agi.node.PbxNode#build()
	 */
	@Override
	protected Object construct() throws FastAgiException {

		try {
			if ((prompts != null) && (prompts.length > 0)) {
				for (PbxMedia pbxMedia : prompts) {
					int i = 1, j = 1;
					boolean isMaxInvalidInput = true;
					boolean isMaxNoInput = true;
					while (isMaxNoInput && isMaxInvalidInput) {
						logger.debug("Get Media Path [" + pbxMedia.getPath() + "]");
						if (!pbxMedia.isInterrupted()) {
							setEscapeDigits(null);
							channel.streamFile(pbxMedia.getPath(), getEscapeDigits());
							input = channel.getData(null, getInputTimeout(), getMaxEntered());
						} else {
							input = channel.getData(pbxMedia.getPath(), getInputTimeout(), getMaxEntered());
						}
						logger.debug("User Entered [" + input + "]");
						if (!TIMEOUT.equalsIgnoreCase(input)) {
							if (i < getMaxInvalidInput()) {
								i++;
								if (((getPattern() != null) && input.matches(getPattern()))
									|| ((input != null) && input.matches("((?=.*\\d).{" + getMinEntered() + "," + getMaxEntered() + "})"))) {
									setUserInput(input);
									return input;
								}
								PbxMedia invalidInputPrompt = getInvalidInputPrompt();
								if (invalidInputPrompt != null) {
									channel.streamFile(invalidInputPrompt.getPath());
								} else {
									logger.info("Invalid Input Prompt is " + invalidInputPrompt);
								}
							} else {
								isMaxInvalidInput = false;
								String invalidInputURI = getInvalidInputURI() == null ? getTargetNode() : getInvalidInputURI();
								logger.info("Come Invalid Input URL is " + invalidInputURI);
								setTargetNode(invalidInputURI);
							}
						}
						if (TIMEOUT.equalsIgnoreCase(input)) {
							if (j < getMaxNoInput()) {
								j++;
								PbxMedia noInputPrompt = getNoInputPrompt();
								if (noInputPrompt != null) {
									channel.streamFile(noInputPrompt.getPath());
								} else {
									logger.info("Invalid Input Prompt is " + noInputPrompt);
								}
							} else {
								isMaxNoInput = false;
								String noInputURI = getNoInputURI() == null ? getTargetNode() : getNoInputURI();
								logger.info("Come No Input URL is " + noInputURI);
								setTargetNode(noInputURI);
							}
						}
					}
				}
			}
		} catch (AgiException e) {
			throw new FastAgiException(e);
		} catch (Exception e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_SHORT_EXCEPTION_DESC);
			throw new FastAgiException(e);
		}
		return input;
	}

	/**
	 * This method for get input
	 *
	 * @return the input
	 */
	public String getInput() {

		return input;
	}

	/**
	 * This method for get invalidInputPrompt
	 *
	 * @return the invalidInputPrompt
	 */
	public PbxMedia getInvalidInputPrompt() {

		return invalidInputPrompt;
	}

	/**
	 * This method for get invalidInputURI
	 *
	 * @return the invalidInputURI
	 */
	public String getInvalidInputURI() {

		return invalidInputURI;
	}

	/**
	 * This method for get maxEntered
	 *
	 * @return the maxEntered
	 */
	public int getMaxEntered() {

		return maxEntered;
	}

	/**
	 * This method for get minEntered
	 *
	 * @return the minEntered
	 */
	public int getMinEntered() {

		return minEntered;
	}

	/**
	 * This method for get noInputPrompt
	 *
	 * @return the noInputPrompt
	 */
	public PbxMedia getNoInputPrompt() {

		return noInputPrompt;
	}

	/**
	 * This method for get noInputURI
	 *
	 * @return the noInputURI
	 */
	public String getNoInputURI() {

		return noInputURI;
	}

	/**
	 * This method for get pattern
	 *
	 * @return the pattern
	 */
	public String getPattern() {

		return pattern;
	}

	/**
	 * This method for get userInput
	 *
	 * @return the userInput
	 */
	public String getUserInput() {

		return userInput;
	}

	/**
	 * This method for set input
	 *
	 * @param input
	 *            the input to set
	 */
	public void setInput(String input) {

		this.input = input;
	}

	/**
	 * This method for set invalidInputPrompt
	 *
	 * @param invalidInputPrompt
	 *            the invalidInputPrompt to set
	 */
	public void setInvalidInputPrompt(PbxMedia invalidInputPrompt) {

		this.invalidInputPrompt = invalidInputPrompt;
	}

	/**
	 * This method for set invalidInputURI
	 *
	 * @param invalidInputURI
	 *            the invalidInputURI to set
	 */
	public void setInvalidInputURI(String invalidInputURI) {

		this.invalidInputURI = invalidInputURI;
	}

	/**
	 * This method for set maxEntered
	 *
	 * @param maxEntered
	 *            the maxEntered to set
	 */
	public void setMaxEntered(int maxEntered) {

		this.maxEntered = maxEntered;
	}

	/**
	 * This method for set minEntered
	 *
	 * @param minEntered
	 *            the minEntered to set
	 */
	public void setMinEntered(int minEntered) {

		this.minEntered = minEntered;
	}

	/**
	 * This method for set noInputPrompt
	 *
	 * @param noInputPrompt
	 *            the noInputPrompt to set
	 */
	public void setNoInputPrompt(PbxMedia noInputPrompt) {

		this.noInputPrompt = noInputPrompt;
	}

	/**
	 * This method for set noInputURI
	 *
	 * @param noInputURI
	 *            the noInputURI to set
	 */
	public void setNoInputURI(String noInputURI) {

		this.noInputURI = noInputURI;
	}

	/**
	 * This method for set pattern
	 *
	 * @param pattern
	 *            the pattern to set
	 */
	public void setPattern(String pattern) {

		this.pattern = pattern;
	}

	/**
	 * This method for set userInput
	 *
	 * @param userInput
	 *            the userInput to set
	 */
	public void setUserInput(String userInput) {

		this.userInput = userInput;
	}
}