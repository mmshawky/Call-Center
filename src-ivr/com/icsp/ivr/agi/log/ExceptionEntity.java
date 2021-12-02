package com.icsp.ivr.agi.log;

import static com.icsp.integ.util.Common.buildException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.MYSQL_ASTERISK;
import static com.icsp.ivr.util.Util.getObjectData;

import com.icsp.integ.db.Entity;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;

/**
 * @author MSH
 *
 */
public class ExceptionEntity extends Entity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private Timestamp			dateLog;
	private Exception			excep;
	private String				exception			= "NAN";
	private long				exeTime;

	@SuppressWarnings ("unchecked")
	public ExceptionEntity(Exception excep, long exeTime) {

		super();
		setExcep(excep);
		setExeTime(exeTime);
		long startMiSec = Calendar.getInstance().getTime().getTime();
		dateLog = new Timestamp(startMiSec);
		setDateLog(dateLog);
		HashMap<String, Object> hashMap = getObjectData(this);
		log(MYSQL_ASTERISK, "asteriskfastagi", LogMapper.class, hashMap);
	}

	public Timestamp getDateLog() {

		return dateLog;
	}

	public Exception getExcep() {

		return excep;
	}

	/**
	 * @return
	 */
	public String getException() {

		if (excep != null) {
			exception = buildException(excep, IS_DETAILED_EXCEPTION_DESC, 6);
		}
		return exception;
	}

	public long getExeTime() {

		return exeTime;
	}

	public void setDateLog(Timestamp dateLog) {

		this.dateLog = dateLog;
	}

	public void setExcep(Exception excep) {

		this.excep = excep;
	}

	/**
	 * @return
	 */
	public void setException(String exception) {

		this.exception = exception;
	}

	public void setExeTime(long exeTime) {

		this.exeTime = exeTime;
	}
}