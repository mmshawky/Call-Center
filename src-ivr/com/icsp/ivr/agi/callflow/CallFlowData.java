/**
 *
 */
package com.icsp.ivr.agi.callflow;

import com.icsp.ivr.util.Language;

import java.net.InetAddress;
import java.util.Map;

/**
 * @author Mostafa M.Shawky
 *
 */
/**
 * @author Mostafa M.Shawky
 *         May 11, 2015 12:59:56 AM
 *
 */
public class CallFlowData {
	
	private String					accountCode;
	private String					callerId;
	private String					callerIdName;
	private String					callerIdNumber;
	private Integer					callingAni2;
	private Integer					callingPres;
	private Integer					callingTns;
	private Integer					callingTon;
	private String					channel;
	private String					context;
	private String					dnid;
	private Boolean					enhanced;
	private String					extension;
	private String					language;
	private InetAddress				localAddress;
	private int						localPort;
	private String					parameter;
	private Map<String, String[]>	parameterMap;
	private String[]				parameterValues;
	private Integer					priority;
	private String					promptPath;
	private Language				callLanguage;
	private String					currencyPromptPath	= "vocabulary" + "/" + "currency" + "/";
	private String					datePromptPath		= "vocabulary" + "/" + "date" + "/";
	private String					numberPromptPath	= "vocabulary" + "/" + "numbers" + "/";
	private String					rdnis;
	private InetAddress				remoteAddress;
	private int						remotePort;
	private Map<?, ?>				request;
	private String					requestURL;
	private String					script;
	private String					targetExtension;
	private String					type;
	private String					uniqueId;
	
	/**
	 *
	 */
	public CallFlowData() {
	
		super();
	}
	
	public String getAccountCode() {
	
		return accountCode;
	}
	
	public String getCallerId() {
	
		return callerId;
	}
	
	public String getCallerIdName() {
	
		return callerIdName;
	}
	
	public String getCallerIdNumber() {
	
		return callerIdNumber;
	}
	
	public Integer getCallingAni2() {
	
		return callingAni2;
	}
	
	public Integer getCallingPres() {
	
		return callingPres;
	}
	
	public Integer getCallingTns() {
	
		return callingTns;
	}
	
	public Integer getCallingTon() {
	
		return callingTon;
	}
	
	/**
	 * @return
	 */
	public Language getCallLanguage() {
	
		return callLanguage;
	}
	
	public String getChannel() {
	
		return channel;
	}
	
	public String getContext() {
	
		return context;
	}
	
	public String getDnid() {
	
		return dnid;
	}
	
	public Boolean getEnhanced() {
	
		return enhanced;
	}
	
	public String getExtension() {
	
		return extension;
	}
	
	public InetAddress getLocalAddress() {
	
		return localAddress;
	}
	
	public int getLocalPort() {
	
		return localPort;
	}
	
	public String getParameter() {
	
		return parameter;
	}
	
	public Map<String, String[]> getParameterMap() {
	
		return parameterMap;
	}
	
	public String[] getParameterValues() {
	
		return parameterValues;
	}
	
	public Integer getPriority() {
	
		return priority;
	}
	
	public String getPromptPath() {
	
		Language language = getCallLanguage();
		String promptPathLang = language == null ? "" : language.name();
		return promptPath != null ? promptPath.concat(promptPathLang + "/") : "";
	}
	
	public String getRdnis() {
	
		return rdnis;
	}
	
	public InetAddress getRemoteAddress() {
	
		return remoteAddress;
	}
	
	public int getRemotePort() {
	
		return remotePort;
	}
	
	public Map<?, ?> getRequest() {
	
		return request;
	}
	
	public String getRequestURL() {
	
		return requestURL;
	}
	
	public String getScript() {
	
		return script;
	}
	
	public String getTargetExtension() {
	
		return targetExtension;
	}
	
	public String getType() {
	
		return type;
	}
	
	public String getUniqueId() {
	
		return uniqueId;
	}
	
	public void setAccountCode(String accountCode) {
	
		this.accountCode = accountCode;
	}
	
	public void setCallerId(String callerId) {
	
		this.callerId = callerId;
	}
	
	public void setCallerIdName(String callerIdName) {
	
		this.callerIdName = callerIdName;
	}
	
	public void setCallerIdNumber(String callerIdNumber) {
	
		this.callerIdNumber = callerIdNumber;
	}
	
	public void setCallingAni2(Integer callingAni2) {
	
		this.callingAni2 = callingAni2;
	}
	
	public void setCallingPres(Integer callingPres) {
	
		this.callingPres = callingPres;
	}
	
	public void setCallingTns(Integer callingTns) {
	
		this.callingTns = callingTns;
	}
	
	public void setCallingTon(Integer callingTon) {
	
		this.callingTon = callingTon;
	}
	
	public void setCallLanguage(Language callLanguage) {
	
		this.callLanguage = callLanguage;
	}
	
	public void setChannel(String channel) {
	
		this.channel = channel;
	}
	
	public void setContext(String context) {
	
		this.context = context;
	}
	
	public void setDnid(String dnid) {
	
		this.dnid = dnid;
	}
	
	public void setEnhanced(Boolean enhanced) {
	
		this.enhanced = enhanced;
	}
	
	public void setExtension(String extension) {
	
		this.extension = extension;
	}
	
	public void setLocalAddress(InetAddress localAddress) {
	
		this.localAddress = localAddress;
	}
	
	public void setLocalPort(int localPort) {
	
		this.localPort = localPort;
	}
	
	public void setParameter(String parameter) {
	
		this.parameter = parameter;
	}
	
	public void setParameterMap(Map<String, String[]> parameterMap) {
	
		this.parameterMap = parameterMap;
	}
	
	public void setParameterValues(String[] parameterValues) {
	
		this.parameterValues = parameterValues;
	}
	
	public void setPriority(Integer priority) {
	
		this.priority = priority;
	}
	
	public void setPromptPath(String promptPath) {
	
		this.promptPath = promptPath;
	}
	
	public void setRdnis(String rdnis) {
	
		this.rdnis = rdnis;
	}
	
	public void setRemoteAddress(InetAddress remoteAddress) {
	
		this.remoteAddress = remoteAddress;
	}
	
	public void setRemotePort(int remotePort) {
	
		this.remotePort = remotePort;
	}
	
	public void setRequest(Map<?, ?> request) {
	
		this.request = request;
	}
	
	public void setRequestURL(String requestURL) {
	
		this.requestURL = requestURL;
	}
	
	public void setScript(String script) {
	
		this.script = script;
	}
	
	public void setTargetExtension(String targetExtension) {
	
		this.targetExtension = targetExtension;
	}
	
	public void setType(String type) {
	
		this.type = type;
	}
	
	public void setUniqueId(String uniqueId) {
	
		this.uniqueId = uniqueId;
	}
	
	/**
	 * @return the currencyPromptPath
	 */
	public String getCurrencyPromptPath() {
	
		return currencyPromptPath;
	}
	
	/**
	 * @param currencyPromptPath
	 *            the currencyPromptPath to set
	 */
	public void setCurrencyPromptPath(String currencyPromptPath) {
	
		this.currencyPromptPath = currencyPromptPath;
	}
	
	/**
	 * @return the datePromptPath
	 */
	public String getDatePromptPath() {
	
		return datePromptPath;
	}
	
	/**
	 * @param datePromptPath
	 *            the datePromptPath to set
	 */
	public void setDatePromptPath(String datePromptPath) {
	
		this.datePromptPath = datePromptPath;
	}
	
	/**
	 * @return the numberPromptPath
	 */
	public String getNumberPromptPath() {
	
		return numberPromptPath;
	}
	
	/**
	 * @param numberPromptPath
	 *            the numberPromptPath to set
	 */
	public void setNumberPromptPath(String numberPromptPath) {
	
		this.numberPromptPath = numberPromptPath;
	}
	
	/**
	 * @return the language
	 */
	public String getLanguage() {
	
		return language;
	}
	
	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
	
		this.language = language;
	}
}