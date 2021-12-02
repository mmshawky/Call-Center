/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.util.Map;

public class DBNoResponseException extends DBAcessException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public DBNoResponseException(Map<String, String> record) {

		super(record);
	}
}