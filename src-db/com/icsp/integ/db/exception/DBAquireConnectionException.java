/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.util.Map;

public class DBAquireConnectionException extends DBAcessException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public DBAquireConnectionException(Map<String, String> record, Exception exception) {

		super(record, exception);
		setStackTrace(exception.getStackTrace());
	}

	public DBAquireConnectionException(Map<String, String> record, String message) {

		super(record, message);
	}
}