/*
 * Created on May 12, 2010
 */
package com.icsp.integ.db.exception;

import java.io.Serializable;

public class BackendNotAvailableException extends Exception implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public BackendNotAvailableException(String message) {

		super(message);
	}
}