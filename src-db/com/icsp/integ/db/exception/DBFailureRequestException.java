/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.util.Map;

public class DBFailureRequestException extends DBAcessException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public DBFailureRequestException(Map<String, String> record) {

		super(record);
	}
}