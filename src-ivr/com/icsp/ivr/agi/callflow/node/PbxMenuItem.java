/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.ivr.util.Util.isValidateMenuItemSelection;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky
 *         Apr 28, 2015 10:49:26 PM
 *
 */
public class PbxMenuItem extends PbxSelectionNode {
	
	private Logger	logger			= Logger.getLogger(getClass());
	// -1 meaning No selection
	protected int	optionDigit		= -1;
	protected char	selectedOption	= ' ';
	
	/**
	 * @param manager
	 *            TODO
	 */
	public PbxMenuItem(AgiChannel channel, PbxNodesManager manager, String id, String escapeDigits, int optionDigit, String targetNode, PbxMedia... prompts) {
	
		super(channel, manager, id, targetNode, prompts);
		setOptionDigit(optionDigit);
		setEscapeDigits(escapeDigits);
	}
	
	@Override
	protected Object construct() throws FastAgiException {
	
		try {
			if ((prompts != null) && (prompts.length > 0)) {
				for (PbxMedia pbxMedia : prompts) {
					if (!pbxMedia.isInterrupted()) {
						setEscapeDigits(null);
					}
					logger.debug("getEscapeDigits(): " + getEscapeDigits());
					logger.debug("pbxMedia.getPath(): " + pbxMedia.getPath());
					logger.debug("getPressTimout(): " + getPressTimout());
					selectedOption = channel.getOption(pbxMedia.getPath(), getEscapeDigits(), getPressTimout());
					if (isValidateMenuItemSelection("0123456789*#", selectedOption)) {
						return selectedOption;
					}
					logger.debug("selectedOption in menu Item " + selectedOption);
				}
			}
			setSelectedOption(String.valueOf(selectedOption));
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
		return selectedOption;
	}
	
	/**
	 * @return the optionNumber
	 */
	protected int getOptionDigit() {
	
		return optionDigit;
	}
	
	/**
	 * @param optionNumber
	 *            the optionNumber to set
	 */
	protected void setOptionDigit(int optionDigit) {
	
		this.optionDigit = optionDigit;
	}
}