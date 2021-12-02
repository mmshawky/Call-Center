/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.ivr.util.Util.isValidateMenuItemSelection;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.exception.FastAgiException;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;

/**
 * @author Mostafa M.Shawky
 */
public class PbxMenu extends PbxSelectionNode {

	private Logger					logger				= Logger.getLogger(getClass());
	private ArrayList<PbxMenuItem>	masterMenuItemsList	= new ArrayList<PbxMenuItem>();
	private PbxMedia				invalidSelectionPrompt;
	private String					maxInvalidSelectionURI;
	private String					maxNoSelectionURI;
	private PbxMedia				noSelectionPrompt;

	/**
	 * @param manager
	 *            TODO
	 */
	public PbxMenu(AgiChannel channel, PbxNodesManager manager, String id, String targetNode, PbxMedia... prompts) {

		super(channel, manager, id, targetNode, prompts);
	}

	/**
	 * This method add menuItes to menu and return true if this menu items add
	 * successful
	 *
	 * @param menuItems
	 * @return true or false according to add status
	 */
	public boolean addMenuItems(PbxMenuItem... menuItems) {

		if ((menuItems != null) && (menuItems.length > 0)) {
			return masterMenuItemsList.addAll(Arrays.asList(menuItems));
		}
		return false;
	}

	@Override
	public String construct() throws FastAgiException {

		try {
			char selectedChar = '0';
			String regex = "";
			if ((masterMenuItemsList != null) && (masterMenuItemsList.size() > 0)) {
				for (PbxMenuItem pbxMenuItem : masterMenuItemsList) {
					regex += pbxMenuItem.getOptionDigit();
				}
				first: for (int i = 0, j = 0; (i < getMaxInvalidSelection()) && (j < getMaxNoSelection()); i++, j++) {
					for (PbxMenuItem pbxMenuItem : masterMenuItemsList) {
						selectedChar = (Character) pbxMenuItem.construct();
						logger.debug("selectedChar " + selectedChar);
						if (isValidateMenuItemSelection(regex, selectedChar)) {
							break first;
						}
						if (String.valueOf(selectedChar).matches("\\d|#|\\*")) {
							if ((getMaxInvalidSelectionURI() != null) && !getMaxInvalidSelectionURI().isEmpty()) {
								targetNode = getMaxInvalidSelectionURI();
							}
							if ((getInvalidSelectionPrompt() != null)) {
								channel.streamFile(getInvalidSelectionPrompt().getPath());
							}
							break;
						}
					}
					if (!String.valueOf(selectedChar).matches("\\d|#|\\*")) {
						if ((getMaxNoSelectionURI() != null) && !getMaxNoSelectionURI().isEmpty()) {
							// return
							targetNode = getMaxNoSelectionURI();
						}
						if ((getNoSelectionPrompt() != null)) {
							channel.streamFile(getNoSelectionPrompt().getPath());
						}
					}
				}
			}
			for (PbxMenuItem pbxMenuItem : masterMenuItemsList) {
				if (String.valueOf(selectedChar).equalsIgnoreCase(String.valueOf(pbxMenuItem.getOptionDigit()))) {
					targetNode = pbxMenuItem.getTargetNode();
					// return targetNode;
				}
			}
			setTargetNode(targetNode);
			logger.debug("selected Node : " + targetNode);
			setSelectedOption(String.valueOf(selectedChar));
			logger.debug("selectedChar : " + selectedChar);
		} catch (Exception e) {
			new FastAgiException(e);
		}
		return targetNode;
	}

	/**
	 * @return the invalidSelectionPrompt
	 */
	public PbxMedia getInvalidSelectionPrompt() {

		return invalidSelectionPrompt;
	}

	/**
	 * This method for get maxInvalidSelectionURI
	 *
	 * @return the maxInvalidSelectionURI
	 */
	public String getMaxInvalidSelectionURI() {

		return maxInvalidSelectionURI;
	}

	/**
	 * This method for get maxNoSelectionURI
	 *
	 * @return the maxNoSelectionURI
	 */
	public String getMaxNoSelectionURI() {

		return maxNoSelectionURI;
	}

	/**
	 * This method return all menus items added to this menu
	 *
	 * @return
	 */
	public ArrayList<PbxMenuItem> getMenuItems() {

		return masterMenuItemsList;
	}

	/**
	 * @return the noSelectionPrompt
	 */
	public PbxMedia getNoSelectionPrompt() {

		return noSelectionPrompt;
	}

	/**
	 * @param invalidSelectionPrompt
	 *            the invalidSelectionPrompt to set
	 */
	public void setInvalidSelectionPrompt(PbxMedia invalidSelectionPrompt) {

		this.invalidSelectionPrompt = invalidSelectionPrompt;
	}

	/**
	 * This method for set maxInvalidSelectionURI
	 *
	 * @param maxInvalidSelectionURI
	 *            the maxInvalidSelectionURI to set
	 */
	public void setMaxInvalidSelectionURI(String maxInvalidSelectionURI) {

		this.maxInvalidSelectionURI = maxInvalidSelectionURI;
	}

	/**
	 * This method for set maxNoSelectionURI
	 *
	 * @param maxNoSelectionURI
	 *            the maxNoSelectionURI to set
	 */
	public void setMaxNoSelectionURI(String maxNoSelectionURI) {

		this.maxNoSelectionURI = maxNoSelectionURI;
	}

	/**
	 * @param noSelectionPrompt
	 *            the noSelectionPrompt to set
	 */
	public void setNoSelectionPrompt(PbxMedia noSelectionPrompt) {

		this.noSelectionPrompt = noSelectionPrompt;
	}
}