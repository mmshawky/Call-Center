/**
 *
 */
package com.icsp.ivr.agi.callflow.node.decision;

import com.icsp.ivr.agi.callflow.media.PbxMedia;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;

/**
 * @author Mostafa M.Shawky
 */
public class PbxWokingDateDecision extends PbxDecision {

	static Logger	logger	= Logger.getLogger(PbxWokingDateDecision.class);

	public static void main(String[] args) throws AgiException {

		WorkingDays workingDays1 = new WorkingDays(Calendar.SATURDAY);
		workingDays1.setWorkingDuraion("8:00:00", "23:59:59");
		WorkingDays workingDays2 = new WorkingDays(Calendar.SUNDAY);
		WorkingDays workingDays3 = new WorkingDays(Calendar.MONDAY);
		WorkingDays workingDays4 = new WorkingDays(Calendar.TUESDAY);
		workingDays4.setWorkingDuraion("8:00:00", "23:37:00");
		WorkingDays workingDays5 = new WorkingDays(Calendar.WEDNESDAY);
		WorkingDays workingDays6 = new WorkingDays(Calendar.THURSDAY);
		workingDays6.setWorkingDuraion("8:00:00", "15:25:00");
		PbxWokingDateDecision dateDecision = new PbxWokingDateDecision(null, null, null, null, null);
		dateDecision.setWorkingDays(workingDays1, workingDays2, workingDays3, workingDays4, workingDays5, workingDays6);
		logger.debug(dateDecision.construct());
	}

	private ArrayList<WorkingDays>	workingDays	= new ArrayList<WorkingDays>(7);

	/**
	 * @param manager
	 *            TODO
	 *
	 */
	public PbxWokingDateDecision(AgiChannel channel, PbxNodesManager manager, String id, String matchTargetNode, String unmatchTargetNode, PbxMedia... prompts) {

		super(channel, manager, id, matchTargetNode, unmatchTargetNode, prompts);
	}

	/**
	 * @return the workingDays
	 */
	public ArrayList<WorkingDays> getWorkingDays() {

		return workingDays;
	}

	@Override
	public boolean match() {

		for (WorkingDays workingDay : workingDays) {
			Calendar currentDate = Calendar.getInstance();
			if (currentDate.get(Calendar.DAY_OF_WEEK) == workingDay.getDayOfWeek()) {
				LinkedList<WorkingDays.Duraion> duraions = workingDay.getWorkingDuraions();
				for (WorkingDays.Duraion duraion : duraions) {
					SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
					Date curDate;
					try {
						curDate = sdf.parse(currentDate.get(Calendar.HOUR_OF_DAY) + ":" + currentDate.get(Calendar.MINUTE) + ":" + currentDate.get(Calendar.SECOND));
					} catch (ParseException e) {
						return false;
					}
					logger.debug("duraion.getStartTime >> " + duraion.getStartTime().getTime());
					logger.debug("duraion.getEndTime() >> " + duraion.getEndTime().getTime());
					logger.debug("currentDate.getTime() >> " + currentDate.getTime().getTime());
					if ((duraion.getStartTime().getTime() <= curDate.getTime()) && (duraion.getEndTime().getTime() >= curDate.getTime())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * @param workingDays
	 *            the workingDays to set
	 */
	public void setWorkingDays(WorkingDays... workingDays) {

		this.workingDays.addAll(Arrays.asList(workingDays));
	}
}