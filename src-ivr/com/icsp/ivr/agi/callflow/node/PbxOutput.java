/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky
 */
public class PbxOutput extends PbxNonSelectionNode {
	
	private Logger	logger	= Logger.getLogger(getClass());
	
	/**
	 * @param manager
	 *            TODO
	 */
	public PbxOutput(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia... prompts) {
	
		super(channel, manager, id, targetNode, prompts);
	}
	
	@Override
	public Object construct() throws FastAgiException {
	
		try {
			logger.error(">>>> "+getId());
			PbxMedia[] prompts = getPrompts();
			if ((prompts != null) && (prompts.length > 0)) {
				for (PbxMedia pbxMedia : prompts) {
					if (!pbxMedia.isInterrupted()) {
						escapeDigits = null;
					}
					channel.controlStreamFile(pbxMedia.getPath(), escapeDigits, 0, null, null, null);
					logger.error("Get Media Path [" + pbxMedia.getPath() + "]");
				}
				logger.error("---------------------------------------------");
			}
		} catch (Exception e) {
			throw new FastAgiException(e);
		}
		return getTargetNode();
	}
}