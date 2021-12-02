/**
 *
 */
package com.icsp.ivr.agi.callflow.node;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static com.icsp.ivr.util.Util.fillObject;

import com.icsp.ivr.agi.callflow.CallFlowData;
import com.icsp.ivr.agi.callflow.event.PbxTransfeerEvent;
import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.callflow.media.PbxPrompt;
import com.icsp.ivr.agi.callflow.media.PbxPromptDigit;
import com.icsp.ivr.agi.callflow.media.PbxPromptNumbers;
import com.icsp.ivr.agi.exception.FastAgiException;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;

/**
 * @author Mostafa M.Shawky
 */
public class PbxNodesManager {
	
	private CallFlowData					callFlowData	= new CallFlowData();
	private Properties						callVariable	= new Properties();
	private AgiChannel						channel;
	private Logger							logger			= Logger.getLogger(getClass());
	private LinkedList<PbxNode>				nodesFlow		= new LinkedList<PbxNode>();
	private LinkedHashMap<String, PbxNode>	uniqNode		= new LinkedHashMap<String, PbxNode>();
	
	public PbxNodesManager(AgiChannel channel, AgiRequest request) {
	
		super();
		this.channel = channel;
		callFlowData = (CallFlowData) fillObject(request, callFlowData);
	}
	
	/**
	 * This method add new node but check first if this node id used before or
	 * not And throw {@link IllegalArgumentException } if this id found inserted
	 * before
	 *
	 * @param pbxNode
	 *            new node to be add
	 * @param id
	 *            Unique id for this node
	 */
	public void addNode(String id, PbxNode pbxNode) {
	
		if (uniqNode.containsKey(id)) {
			logger.error("Can't use same node id " + id);
			logException("Error In " + getClass().getName(), new IllegalArgumentException("Can't use same node id " + id), LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		} else {
			uniqNode.put(id, pbxNode);
		}
	}
	
	public void addToCallHistory(PbxNode pbxNode) {
	
		logger.debug("Add Node to history : " + pbxNode.getId());
		nodesFlow.addLast(pbxNode);
	}
	
	public PbxInput createPbxInput(String id, String targetNode, PbxMedia prompt) {
	
		return new PbxInput(channel, this, id, targetNode, prompt);
	}
	
	public PbxMenu createPbxMenu(String id, String targetNode, PbxMedia... prompts) {
	
		return new PbxMenu(channel, this, id, targetNode, prompts);
	}
	
	public PbxMenuItem createPbxMenuItem(String id, String escapeDigits, int optionDigit, String targetNode, PbxMedia... prompts) {
	
		return new PbxMenuItem(channel, this, id, escapeDigits, optionDigit, targetNode, prompts);
	}
	
	public PbxOutput createPbxOutput(String id, String targetNode, PbxMedia... prompts) {
	
		return new PbxOutput(channel, this, id, targetNode, prompts);
	}
	
	public PbxPrompt createPbxPrompt(String prompt) {
	
		return new PbxPrompt(channel, this, prompt);
	}
	
	/**
	 * This method return list of PbxPrompt {@link PbxPrompt} builded according to given number
	 * 
	 * @param numbers
	 * @return
	 */
	public PbxPromptNumbers[] createPbxPromptNumbers(String number) {
	
		PbxPromptNumbers pbxPromptNumbers = new PbxPromptNumbers(channel, this, number);
		return pbxPromptNumbers.createPbxPromptNumbers();
	}
	
	/**
	 * 
	 * @param digits
	 * @return
	 */
	public PbxPromptDigit[] createPbxPromptDigits(String digit) {
	
		PbxPromptDigit pbxPromptDigit = new PbxPromptDigit(channel, this, digit);
		return pbxPromptDigit.createPbxPromptDigits();
	}
	
	/**
	 * This method return prompt with first char from string or all the string if includes only one char
	 * 
	 * @param digit
	 * @return
	 */
	public PbxPromptDigit createPbxPromptDigit(String digit) {
	
		PbxPromptDigit pbxPromptDigit = new PbxPromptDigit(channel, this, digit);
		return pbxPromptDigit.createPbxPromptDigits()[0];
	}
	
	public PbxTerminate createPbxTerminate(String id, String targetNode, PbxMedia... prompts) {
	
		return new PbxTerminate(channel, this, id, targetNode, prompts);
	}
	
	public PbxTransfeer createPbxTransfeer(String id, String extension, PbxMedia... prompts) {
	
		return new PbxTransfeer(channel, this, id, extension, prompts);
	}
	
	/**
	 *
	 * @return
	 */
	public CallFlowData getCallFlowData() {
	
		return callFlowData;
	}
	
	public List<PbxNode> getCallHistory() {
	
		return nodesFlow;
	}
	
	public Object getCallVariable(String key) {
	
		return callVariable.get(key);
	}
	
	/**
	 * @param nodeId
	 * @return
	 * @throws AgiException
	 */
	public String getNextNode(String nodeId) throws FastAgiException, PbxTransfeerEvent {
	
		PbxNode node = getNodeById(nodeId);
		String targetNode = null;
		if (node != null) {
			node.play();
			
			if (node instanceof PbxTransfeer) {
				throw new PbxTransfeerEvent("Transfeer Call to Agent " + ((PbxTransfeer) node).getExtension());
			}
			targetNode = node.getTargetNode();
			logger.debug("node.getTargetNode() : " + targetNode);
		} else {
			throw new FastAgiException("Node Can't Be " + node);
		}
		return getNextNode(targetNode);
	}
	
	public PbxNode getNodeById(String id) {
	
		logger.debug("getNodeById : " + uniqNode.get(id));
		return uniqNode.get(id);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public PbxNode getPreviousNode(String nodeId) {
	
		int idx = nodesFlow.indexOf(nodeId);
		if (idx <= 0) {
			return null;
		}
		return nodesFlow.get(idx - 1);
	}
	
	public PbxNode[] listNode() {
	
		Collection<PbxNode> values = uniqNode.values();
		PbxNode[] nodes = new PbxNode [values.size()];
		for (int i = 0; i < nodes.length; i++) {
			System.arraycopy(values.toArray(), 0, nodes, 0, values.toArray().length);
		}
		return nodes;
	}
	
	/**
	 * This method remove node from call manager and return removed node
	 *
	 * @see <code>LinkedHashMap</code>
	 * @param id
	 * @return
	 */
	public PbxNode removeNode(String id) {
	
		return uniqNode.remove(id);
	}
	
	/**
	 *
	 * @param callFlowData
	 */
	public void setCallFlowData(CallFlowData callFlowData) {
	
		this.callFlowData = callFlowData;
	}
	
	public void setCallVariable(String key, Object value) {
	
		callVariable.put(key, value);
	}
}