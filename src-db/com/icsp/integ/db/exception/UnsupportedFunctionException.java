/*
 * Created on Nov 30, 2009
 */
package com.icsp.integ.db.exception;

import java.io.Serializable;

public class UnsupportedFunctionException extends Exception implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public UnsupportedFunctionException(String message) {

		super(message);
	}
}
