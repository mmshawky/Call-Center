/**
 *
 */
package com.icsp.ivr.agi.exception;

/**
 * @author Mostafa M.Shawky
 *         Apr 28, 2015
 *
 */
public class FastAgiException extends RuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 8539889164368141535L;

	/**
	 *
	 */
	public FastAgiException() {

		super();
	}

	/**
	 * @param message
	 */
	public FastAgiException(String message) {

		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public FastAgiException(String message, Throwable cause) {

		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public FastAgiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {

		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param cause
	 */
	public FastAgiException(Throwable cause) {

		super(cause);
	}
}