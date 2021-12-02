/**
 *
 */
package com.icsp.ivr.agi.callflow.manager;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerConnectionFactory;
import org.asteriskjava.manager.ManagerEventListener;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.event.ManagerEvent;

/**
 * @author Mostafa
 */
public class AGIManager implements ManagerEventListener {

	static boolean	listen		= true;
	static boolean	notListen	= false;

	public static void main(String[] args) throws Exception {

		AGIManager helloManager = new AGIManager();
		helloManager.run();
	}

	Logger						logger	= Logger.getLogger(getClass());
	/**
	 *
	 */
	private ManagerConnection	managerConnection;

	public AGIManager() throws IOException {

		ManagerConnectionFactory factory = new ManagerConnectionFactory("192.168.100.100", "admin", "STC900_icm");
		managerConnection = factory.createManagerConnection();
		managerConnection.addEventListener(this);
		System.setProperty("org.asteriskjava.trace", "true");
		System.setProperty("org.asteriskjava.trace.directory", "/home/admin/Elastix-Config/workspace/CustomAsteriskAGI/");
	}

	@Override
	public void onManagerEvent(ManagerEvent event) {

		logger.debug("event.getFile() " + event.getFile());
		if ("app_queue.c".equalsIgnoreCase(event.getFile())) {
			listen = false;
			notListen = true;
		}
		logger.debug(event.getSource().toString());
		// logger.debug("event.getDateReceived() " + event.getDateReceived());
	}

	public synchronized void run() throws IOException, AuthenticationFailedException, TimeoutException, InterruptedException {

		// OriginateAction originateAction;
		// ManagerResponse originateResponse;
		// AgentsAction agentsAction = new AgentsAction();
		// agentsAction.setActionId("10");
		// QueueAddAction queueAddAction = new QueueAddAction();
		// queueAddAction.setInterface("SIP/Mostafa");
		// queueAddAction.setQueue("billing");
		// originateAction = new OriginateAction();
		// originateAction.setChannel("SIP/Mostafa");
		// originateAction.setContext("from-internal");
		// originateAction.setExten("1000");
		// originateAction.setPriority(new Integer(1));
		// originateAction.setTimeout(new Integer(60000));
		// connect to Asterisk and log in
		// managerConnection.login();
		// send the originate action and wait for a maximum of 30 seconds for
		// Asterisk
		// to send a reply
		// originateResponse = managerConnection.sendAction(agentsAction,
		// 60000);
		// print out whether the originate succeeded or not
		// logger.debug(">>>>>>>>>>>> " + originateResponse.getMessage());
		// wait 10 seconds for events to come in
		// Thread.sleep(10000);
		// and finally log off and disconnect
		// managerConnection.logoff();
		// connect to Asterisk and log in
		managerConnection.login();
		// request channel state
		// managerConnection.sendAction(new StatusAction());
		// wait 10 seconds for events to come in
		// Thread.sleep(10 * 60 * 1000);
		while (listen) {
			logger.debug("Come to waiting ....");
			wait();
		}
		while (notListen) {
			logger.debug("Come to notifing ....");
			notify();
		}
		// and finally log off and disconnect
		managerConnection.logoff();
	}
}
