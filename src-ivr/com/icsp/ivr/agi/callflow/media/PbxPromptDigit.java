package com.icsp.ivr.agi.callflow.media;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.dynamicsay.digits.Digits;
import com.icsp.ivr.dynamicsay.numbers.Numbers;

import java.util.List;

import org.asteriskjava.fastagi.AgiChannel;

public class PbxPromptDigit extends PbxPrompt {
	
	private String	digit;
	private Digits	digits;
	
	public PbxPromptDigit(AgiChannel channel, PbxNodesManager manager, String digit) {
	
		super(channel, manager, digit);
		this.digit = digit;
		this.digits = new Digits(digit);
	}
	
	/**
	 * This method return list of PbxPrompt {@link PbxPrompt} builded according to given number
	 * {@link Numbers}
	 * 
	 * @param numbers
	 * @return
	 */
	public PbxPromptDigit[] createPbxPromptDigits() {
	
		List<String> digitList = digits.say();
		PbxPromptDigit[] pbxPrompts = new PbxPromptDigit [digitList.size()];
		CallFlowData callFlowData = manager.getCallFlowData();
		String pathNumber = callFlowData.getNumberPromptPath();
		for (int i = 0; i < digitList.size(); i++) {
			String digitFullPath = pathNumber + digitList.get(i);
			pbxPrompts[i] = new PbxPromptDigit(channel, manager, digitFullPath);
		}
		return pbxPrompts;
	}
	
	/**
	 * @return the digit
	 */
	public String getDigit() {
	
		return digit;
	}
	
	/**
	 * @param digit
	 *            the digit to set
	 */
	public void setDigit(String digit) {
	
		this.digit = digit;
	}
	
	/**
	 * @return the digits
	 */
	public Digits getDigits() {
	
		return digits;
	}
	
	/**
	 * @param digits
	 *            the digits to set
	 */
	public void setDigits(Digits digits) {
	
		this.digits = digits;
	}
}