/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DBAcessException extends Exception implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private Map<String, String>	record;

	public DBAcessException(Map<String, String> record) {

		this.record = record;
	}

	public DBAcessException(Map<String, String> record, Exception ex) {

		super(ex);
		this.record = record;
	}

	public DBAcessException(Map<String, String> record, String message) {

		super(message);
		this.record = record;
	}

	/**
	 * @return the record
	 */
	public Map<String, String> getRecord() {

		return record;
	}

	/**
	 * @param record
	 *            the record to set
	 */
	public void setRecord(HashMap<String, String> record) {

		this.record = record;
	}
}