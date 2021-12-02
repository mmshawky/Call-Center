package com.icsp.ivr.agi.callflow.media;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.dynamicsay.numbers.Numbers;

import java.util.List;

import org.asteriskjava.fastagi.AgiChannel;

public class PbxPromptNumbers extends PbxPrompt {
	
	private String	number;
	private Numbers	numbers;
	
	/**
	 * @param channel
	 * @param manager
	 * @param prompt
	 */
	public PbxPromptNumbers(AgiChannel channel, PbxNodesManager manager, String number) {
	
		super(channel, manager, number);
		this.number = number;
		CallFlowData callFlowData = manager.getCallFlowData();
		this.numbers = Numbers.getInstance(Double.valueOf(number), callFlowData.getCallLanguage());
	}
	
	/**
	 * This method return list of PbxPrompt {@link PbxPrompt} builded according to given number
	 * {@link Numbers}
	 * 
	 * @param numbers
	 * @return
	 */
	public PbxPromptNumbers[] createPbxPromptNumbers() {
	
		CallFlowData callFlowData = manager.getCallFlowData();
		List<String> numberList = numbers.say();
		PbxPromptNumbers[] pbxPrompts = new PbxPromptNumbers [numberList.size()];
		String pathNumber = callFlowData.getNumberPromptPath();
		for (int i = 0; i < numberList.size(); i++) {
			String numberFullPath = pathNumber + numberList.get(i);
			PbxPromptNumbers promptNumbers = new PbxPromptNumbers(channel, manager, number);
			promptNumbers.setPath(numberFullPath);
			pbxPrompts[i] = promptNumbers;
		}
		return pbxPrompts;
	}
	
	/**
	 * @return the number
	 */
	public String getNumber() {
	
		return number;
	}
	
	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
	
		this.number = number;
	}
	
	/**
	 * @return the numbers
	 */
	public Numbers getNumbers() {
	
		return numbers;
	}
	
	/**
	 * @param numbers
	 *            the numbers to set
	 */
	public void setNumbers(Numbers numbers) {
	
		this.numbers = numbers;
	}
}