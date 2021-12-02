/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.util.Map;

public class DBSqlException extends DBAcessException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public DBSqlException(Map<String, String> record, Exception exception) {

		super(record, exception);
		setStackTrace(exception.getStackTrace());
	}

	public DBSqlException(Map<String, String> record, String message) {

		super(record, message);
	}
}