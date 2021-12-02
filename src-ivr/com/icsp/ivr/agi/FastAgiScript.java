/**
 *
 */
package com.icsp.ivr.agi;

import static com.icsp.integ.util.Common.log;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.ivr.agi.callflow.CallFlowFactory;
import com.icsp.ivr.agi.callflow.db.CallflowEntity;
import com.icsp.ivr.agi.callflow.event.PbxTerminationEvent;
import com.icsp.ivr.agi.callflow.event.PbxTransfeerEvent;
import com.icsp.ivr.agi.callflow.node.PbxNode;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;
import com.icsp.ivr.agi.exception.FastAgiException;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiHangupException;
import org.asteriskjava.fastagi.AgiNetworkException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.AgiSpeechException;
import org.asteriskjava.fastagi.BaseAgiScript;

/**
 * @author Mostafa M.Shawky
 */
@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (name = "",propOrder = { "path" })
public class FastAgiScript extends BaseAgiScript implements CallFlowFactory {
	
	@XmlAttribute (name = "issherad")
	protected Boolean	issherad;
	@XmlElement (required = true)
	protected String	path;
	
	/**
	 *
	 */
	public FastAgiScript() {
	
		super();
	}
	
	@Override
	public void initCallFlow(PbxNodesManager manager) {
	
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void service(AgiRequest request, AgiChannel channel) throws AgiException {
	
		PbxNodesManager manager = null;
		try {
			// String[] strings = request.getArguments();
			// for (String string : strings) {
			// // logger.debug("Args " + string);
			// }
			// logger.info("New Call");
			channel.answer();
			// DatabaseGetCommand databaseGetCommand = new
			// DatabaseGetCommand("SIP", "Registry/1000");
			//
			// AgiReply agiReply = channel.sendCommand(databaseGetCommand);
			// logger.debug("Data >> : " + agiReply.toString());
			// logger.debug("UniqueId Is :[" + channel.getUniqueId() + "]");
			manager = new PbxNodesManager(channel, request);
			try {
				Class<?> classes = Class.forName(getPath());
				CallFlowFactory factory = (CallFlowFactory) classes.newInstance();
				factory.initCallFlow(manager);
			} catch (Exception e) {
				logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
				System.exit(0);
			}
			//
			Object[] ids = manager.listNode();
			PbxNode nodeCheel = (PbxNode) ids[0];
			manager.getNextNode(nodeCheel.getId());
			//
		} catch (AgiHangupException e) {
			log(e.getMessage());
		} catch (AgiNetworkException e) {
			log(e.getMessage());
		} catch (AgiSpeechException e) {
			log(e.getMessage());
		} catch (PbxTransfeerEvent e) {
			log(e.getMessage());
		} catch (PbxTerminationEvent e) {
			log(e.getMessage());
		} catch (FastAgiException e) {
			try {
				channel.hangup();
			} catch (Exception e2) {
				log(e.getMessage());
			}
		} catch (Exception e) {
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			channel.hangup();
		}
		finally {
			new CallflowEntity(manager);
		}
	}
	
	/**
	 * Sets the value of the issherad property.
	 *
	 * @param value
	 *            allowed object is {@link Boolean }
	 *
	 */
	public void setIssherad(Boolean value) {
	
		this.issherad = value;
	}
	
	/**
	 * Gets the value of the issherad property.
	 *
	 * @return possible object is {@link Boolean }
	 *
	 */
	public Boolean isIssherad() {
	
		return issherad;
	}
	
	/**
	 * Sets the value of the path property.
	 *
	 * @param value
	 *            allowed object is {@link String }
	 *
	 */
	public void setPath(String path) {
	
		this.path = path;
	}
	
	/**
	 * Gets the value of the path property.
	 *
	 * @return possible object is {@link String }
	 *
	 */
	public String getPath() {
	
		return path;
	}
}