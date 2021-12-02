/**
 *
 */
package com.icsp.ivr.agi.callflow.node.decision;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/**
 * @author Mostafa M.Shawky
 */
public class WorkingDays {

	class Duraion {

		private Date	endTime;
		private Date	startTime;

		Duraion(Date startTime, Date endTime) {

			this.startTime = startTime;
			this.endTime = endTime;
		}

		/**
		 * @return the endTime
		 */
		protected Date getEndTime() {

			return endTime;
		}

		/**
		 * @return the startTime
		 */
		protected Date getStartTime() {

			return startTime;
		}

		/**
		 * @param endTime
		 *            the endTime to set
		 */
		protected void setEndTime(Date endTime) {

			this.endTime = endTime;
		}

		/**
		 * @param startTime
		 *            the startTime to set
		 */
		protected void setStartTime(Date startTime) {

			this.startTime = startTime;
		}
	}

	private int					dayOfWeek		= -1;
	/**
	 *
	 */
	private LinkedList<Duraion>	workingDuraions	= new LinkedList<Duraion>();

	/**
	 *
	 */
	public WorkingDays() {

		super();
	}

	public WorkingDays(int dayOfWeek) {

		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @return the dayOfWeek
	 */
	public int getDayOfWeek() {

		return dayOfWeek;
	}

	/**
	 * @return the workingDuraions
	 */
	public LinkedList<Duraion> getWorkingDuraions() {

		return workingDuraions;
	}

	/**
	 * @param dayOfWeek
	 *            the dayOfWeek to set
	 */
	public void setDayOfWeek(int dayOfWeek) {

		this.dayOfWeek = dayOfWeek;
	}

	/**
	 * @param workingDuraions
	 *            the workingDuraions to set
	 */
	public void setWorkingDuraion(String start, String end) {

		try {
			start = start == null ? "00:00:00" : start;
			end = end == null ? "23:59:59" : end;
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
			Date startDate = sdf.parse(start);
			Date endDate = sdf.parse(end);
			Duraion duraion = new Duraion(startDate, endDate);
			this.workingDuraions.add(duraion);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}