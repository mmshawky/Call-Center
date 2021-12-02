package com.icsp.ots.callflow;

import java.util.Random;

import org.apache.log4j.Logger;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.CallFlowFactory;
import com.icsp.ivr.agi.callflow.media.PbxPrompt;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.agi.callflow.node.PbxOutput;
import com.icsp.ivr.agi.callflow.node.PbxTransfeer;
import com.icsp.ivr.util.Language;

/**
 * @author Mostafa M.Shawky
 */
public class TestCallflow implements CallFlowFactory {
	
	Logger	logger	= Logger.getLogger(getClass());
	
	/**
	 *
	 */
	public TestCallflow() {
	
		super();
	}
	
	@SuppressWarnings("unused")
	@Override
	public void initCallFlow(PbxNodesManager manager) {
	
		try {
			// channel.setContext("from-internal");
			String defaultPromptPath = "custom/hde/";
			CallFlowData callFlowData = manager.getCallFlowData();
			callFlowData.setPromptPath(defaultPromptPath);
			callFlowData.setCallLanguage(Language.Ar);
			logger.debug(callFlowData.getCallerIdNumber());
			logger.debug(callFlowData.getCallingTns());
			logger.debug(callFlowData.getChannel());
			logger.debug(callFlowData.getDnid());
			logger.debug(callFlowData.getContext());
			logger.debug(callFlowData.getRequestURL());
			// PbxPrompt welcomePrompt = manager.createPbxPrompt("Welcome");
			// PbxOutput welcomeOutput =
			// manager.createPbxOutput("WelcomeMessage", "LanguageMenu",
			// welcomePrompt);
			//
			// //
			// PbxPrompt arPrompt =
			// manager.createPbxPrompt("ForArabicPressOne");
			//
			// PbxMenuItem arPbxMenuItem =
			// manager.createPbxMenuItem("ArabicMenuItem", "0123456789*#", 1,
			// "EnterExtOrZeroForOperator", arPrompt);
			//
			// //
			// PbxPrompt enPrompt =
			// manager.createPbxPrompt("ForEnglishPressTwo");
			// PbxMenuItem enPbxMenuItem =
			// manager.createPbxMenuItem("EnglishMenuItem", "0123456789*#", 2,
			// "EnterExtOrZeroForOperator", enPrompt);
			// enPbxMenuItem.setPressTimout(5);
			// //
			// --------------------------------------------------------------------------------------
			// PbxPrompt noSelectionPrompt =
			// manager.createPbxPrompt("NoSelection");
			// PbxPrompt invalidSelectionPrompt =
			// manager.createPbxPrompt("InvalidSelection");
			// //
			// ---------------------------------------------------------------------------------------
			// PbxMenu languageMenu = manager.createPbxMenu("LanguageMenu",
			// "EnterExtOrZeroForOperator");
			// languageMenu.setMaxNoSelection(1);
			// languageMenu.setMaxNoSelectionURI("EnterExtOrZeroForOperator");
			// languageMenu.addMenuItems(arPbxMenuItem, enPbxMenuItem);
			// languageMenu.addModulator(new LanguageSetterModulator());
			//
			double min = 0;
			double max = 999999999;
			for (int i = 0; i < 500; i++) {
				Random random = new Random();
				int value = (int) (max * random.nextDouble());
				logger.error(value);
				PbxPrompt[] pbxPromptNumbers = manager.createPbxPromptNumbers(value + "");
				PbxOutput pbxOutput = manager.createPbxOutput("TestNumbers" + i, "TestNumbers" + (i + 1), pbxPromptNumbers);
				int value2 = (int) (max * random.nextDouble());
				PbxPrompt[] pbxPromptNumbers2 = manager.createPbxPromptNumbers(value2 + "");
				PbxOutput pbxOutput2 = manager.createPbxOutput("TestNumbers" + (i + 1), "TestNumbers" + (i + 2), pbxPromptNumbers2);
				i++;
			}
			// PbxPrompt[] pbxPromptNumbers = manager.createPbxPromptNumbers("58963");
			// PbxOutput pbxOutput = manager.createPbxOutput("TestNumbers", "TestNumbers2", pbxPromptNumbers);
			//
			//
			// pbxPromptNumbers = manager.createPbxPromptNumbers("88885");
			// pbxOutput = manager.createPbxOutput("TestNumbers2", "TestNumbers3", pbxPromptNumbers);
			//
			//
			// pbxPromptNumbers = manager.createPbxPromptNumbers("96321511");
			// pbxOutput = manager.createPbxOutput("TestNumbers3", "SalesAgent", pbxPromptNumbers);
			// PbxPrompt noInputPrompt = manager.createPbxPrompt("NoSelection");
			// PbxPrompt invalidInputPrompt = manager.createPbxPrompt("InvalidSelection");
			// //
			// PbxPrompt enterExtOrZeroForOperatorPrompt =
			// manager.createPbxPrompt("EnterExtOrZeroForOperator");
			// enterExtOrZeroForOperatorPrompt.setInterrupted(true);
			// PbxInput input = manager.createPbxInput("EnterExtOrZeroForOperator", "MainMenu",
			// enterExtOrZeroForOperatorPrompt);
			// // input.addModulator(new ExtensionSetterModulator());
			// input.setMaxEntered(9);
			// input.setMinEntered(3);
			// input.setMaxNoInput(2);
			// input.setMaxInvalidInput(3);
			// input.setInvalidInputPrompt(invalidInputPrompt);
			// input.setNoInputPrompt(noInputPrompt);
			// input.setInvalidInputURI("SalesAgent");
			// PbxPrompt salesPrompt = manager.createPbxPrompt("ForSalesPressOne");
			// PbxMenuItem salesPbxMenuItem = manager.createPbxMenuItem("SalesMenuItem", "0123456789*#", 1,
			// "SalesAgent", salesPrompt);
			// //
			// PbxPrompt pricesAndOffersPrompt = manager.createPbxPrompt("ForPricesAndOffersPressTwo");
			// PbxMenuItem pricesAndOffersPbxMenuItem = manager.createPbxMenuItem("PricesAndOffersMenuItem",
			// "0123456789*#", 2, "PricesAndOffersAgent", pricesAndOffersPrompt);
			// PbxPrompt techSupportPrompt = manager.createPbxPrompt("ForTechSupportPressThree");
			// PbxMenuItem techSupportPbxMenuItem = manager.createPbxMenuItem("TechSupportMenuItem",
			// "0123456789*#", 3, "TechSupportAgent", techSupportPrompt);
			// //
			// PbxPrompt customerServicesPrompt = manager.createPbxPrompt("ForCustomerServicesPressFour");
			// PbxMenuItem customerServicesPbxMenuItem = manager.createPbxMenuItem("CustomerServicesMenuItem",
			// "0123456789*#", 4, "CustomerServicesAgent", customerServicesPrompt);
			// //
			// PbxPrompt assistancePrompt = manager.createPbxPrompt("ForAssistancePressZero");
			// PbxMenuItem assistancePbxMenuItem = manager.createPbxMenuItem("AssistanceMenuItem",
			// "0123456789*#", 0, "AssistanceExtension", assistancePrompt);
			// //
			// PbxMenu mainMenu = manager.createPbxMenu("MainMenu", "Main");
			// mainMenu.setMaxNoSelection(3);
			// mainMenu.setMaxInvalidSelection(1);
			// mainMenu.setMaxNoSelectionURI("Termination");
			// mainMenu.setMaxInvalidSelectionURI("Termination");
			// mainMenu.setNoSelectionPrompt(noInputPrompt);
			// mainMenu.setInvalidSelectionPrompt(invalidInputPrompt);
			// mainMenu.addMenuItems(salesPbxMenuItem, pricesAndOffersPbxMenuItem, techSupportPbxMenuItem,
			// customerServicesPbxMenuItem, assistancePbxMenuItem);
			// //
			PbxTransfeer salesAgent = manager.createPbxTransfeer("SalesAgent", "5000");
			// PbxTransfeer pricesAndOffersAgent =
			// manager.createPbxTransfeer("PricesAndOffersAgent", "5000");
			// PbxTransfeer techSupportAgent =
			// manager.createPbxTransfeer("TechSupportAgent", "5000");
			// PbxTransfeer customerServicesAgent =
			// manager.createPbxTransfeer("CustomerServicesAgent", "5000");
			// //
			// PbxTransfeer assistanceExtension =
			// manager.createPbxTransfeer("AssistanceExtension", "5000");
			// PbxTransfeer selectedExtension =
			// manager.createPbxTransfeer("SelectedExtension", null);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}
	}
}