package com.icsp.ivr.agi;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import org.asteriskjava.fastagi.AbstractMappingStrategy;
import org.asteriskjava.fastagi.AgiRequest;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlType (name = "",propOrder = { "callflowscript" })
public class XMLMappingStrategy extends AbstractMappingStrategy {

	@XmlElement (required = true)
	protected FastAgiScript	callflowscript;

	public XMLMappingStrategy() {

		super();
	}

	@Override
	public FastAgiScript determineScript(AgiRequest request) {

		return getCallflowscript();
	}

	/**
	 * Gets the value of the callflowscript property.
	 *
	 * @return
	 *         possible object is {@link Server.Callflowscript }
	 *
	 */
	public FastAgiScript getCallflowscript() {

		return callflowscript;
	}

	/**
	 * Sets the value of the callflowscript property.
	 *
	 * @param value
	 *            allowed object is {@link Server.Callflowscript }
	 *
	 */
	public void setCallflowscript(FastAgiScript value) {

		this.callflowscript = value;
	}
}