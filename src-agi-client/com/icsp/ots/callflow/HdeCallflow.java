package com.icsp.ots.callflow;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.CallFlowFactory;
import com.icsp.ivr.agi.callflow.media.PbxPrompt;
import com.icsp.ivr.agi.callflow.node.PbxMenu;
import com.icsp.ivr.agi.callflow.node.PbxMenuItem;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.agi.callflow.node.PbxTransfeer;
import com.icsp.ots.callflow.modulators.LanguageSetterModulator;

import org.apache.log4j.Logger;

/**
 * @author Mostafa M.Shawky
 */
public class HdeCallflow implements CallFlowFactory {

	Logger logger = Logger.getLogger(getClass());

	/**
	 *
	 */
	public HdeCallflow() {

		super();
	}

	@Override
	public void initCallFlow(PbxNodesManager manager) {

		try {
			// channel.setContext("from-internal");
			String defaultPromptPath = "custom/hde/";
			CallFlowData callFlowData = manager.getCallFlowData();
			callFlowData.setPromptPath(defaultPromptPath);
			logger.debug(callFlowData.getCallerIdNumber());
			logger.debug(callFlowData.getCallingTns());
			logger.debug(callFlowData.getChannel());
			logger.debug(callFlowData.getDnid());
			logger.debug(callFlowData.getContext());
			logger.debug(callFlowData.getRequestURL());
			// --------------------------------------------------------------------------------------
			// PbxPrompt noSelectionPrompt = manager.createPbxPrompt("common/noSelection");
			// PbxPrompt invalidSelectionPrompt =
			// manager.createPbxPrompt("common/invalidSelection");
			PbxPrompt invalidInputPrompt = manager.createPbxPrompt("common/invalidInput");
			PbxPrompt noInputPrompt = manager.createPbxPrompt("common/noInput");
			PbxPrompt onePrompt = manager.createPbxPromptDigit("1");
			PbxPrompt twoPrompt = manager.createPbxPromptDigit("2");
			// PbxPrompt pressPrompt = manager.createPbxPrompt("common/pressNum");
			// ---------------------------------------------------------------------------------------
			// PbxPrompt welcomePrompt = manager.createPbxPrompt("welcomeMessage");
			// PbxOutput welcomeOutput = manager.createPbxOutput("WelcomeMessage",
			// "LanguageMenu", welcomePrompt);
			//
			PbxPrompt arPrompt = manager.createPbxPrompt("forArabic");
			PbxMenuItem arPbxMenuItem = manager.createPbxMenuItem("ArabicMenuItem", "0123456789*#", 1, "MainMenu", arPrompt);
			//
			PbxPrompt enPrompt = manager.createPbxPrompt("forEnglish");
			PbxMenuItem enPbxMenuItem = manager.createPbxMenuItem("EnglishMenuItem", "0123456789*#", 2, "MainMenu", enPrompt);
			//
			PbxMenu languageMenu = manager.createPbxMenu("LanguageMenu", "MainMenu");
			languageMenu.setMaxNoSelection(1);
			languageMenu.setMaxInvalidSelection(1);
			languageMenu.addMenuItems(arPbxMenuItem, enPbxMenuItem);
			languageMenu.addModulator(new LanguageSetterModulator());
			//
			PbxPrompt selectPrompt = manager.createPbxPrompt("common/selectNum");
			//
			PbxPrompt selfOrderPrompt = manager.createPbxPrompt("menuOfmenus/selfOrder");
			PbxMenuItem selfOrderPbxMenuItem = manager.createPbxMenuItem("SelfOrderMenuItem", "0123456789*#", 1, "OrderAgent", selfOrderPrompt,
					selectPrompt, onePrompt);
			//
			PbxPrompt agentPrompt = manager.createPbxPrompt("common/toSpeakToAgent");
			PbxMenuItem agentPbxMenuItem = manager.createPbxMenuItem("AgentMenuItem", "0123456789*#", 2, "OrderAgent", agentPrompt, selectPrompt,
					twoPrompt);
			PbxMenu mainMenu = manager.createPbxMenu("MainMenu", "OrderAgent");
			mainMenu.setMaxNoSelection(3);
			mainMenu.setMaxInvalidSelection(3);
			mainMenu.setMaxNoSelectionURI("OrderAgent");
			mainMenu.setMaxInvalidSelectionURI("OrderAgent");
			mainMenu.setNoSelectionPrompt(noInputPrompt);
			mainMenu.setInvalidSelectionPrompt(invalidInputPrompt);
			mainMenu.addMenuItems(selfOrderPbxMenuItem, agentPbxMenuItem);
			//
			PbxTransfeer orderAgent = manager.createPbxTransfeer("OrderAgent", "5000");
			logger.debug("OrderAgent" + orderAgent);
		} catch (Exception e) {
			logger.error(e);
		}
	}
}