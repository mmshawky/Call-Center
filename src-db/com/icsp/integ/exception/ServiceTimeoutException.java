/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Constants.TIME_OUT_ERROR_CODE;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ServiceTimeoutException extends ServiceRuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public ServiceTimeoutException() {

		this(TIME_OUT_ERROR_CODE, "Timeout Error");
	}

	public ServiceTimeoutException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}

	public ServiceTimeoutException(String errorDescription, Throwable throwable) {

		super(TIME_OUT_ERROR_CODE, errorDescription, throwable);
	}

	public ServiceTimeoutException(Throwable throwable) {

		super(TIME_OUT_ERROR_CODE, "Timeout Error", throwable);
	}
}