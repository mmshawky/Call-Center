/*
 * Created on May 08, 2010
 */
package com.icsp.integ.db.exception;

import java.io.Serializable;

public class UnauthorizedAccessException extends Exception implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public UnauthorizedAccessException(String message) {

		super(message);
	}
}