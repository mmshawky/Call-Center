/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Constants.APPLICATION_ERROR_CODE;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ServiceApplicationException extends ServiceRuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public ServiceApplicationException() {

		this(APPLICATION_ERROR_CODE, "Application Error");
	}

	public ServiceApplicationException(String errorDescription) {

		super(APPLICATION_ERROR_CODE, errorDescription);
	}

	public ServiceApplicationException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}

	public ServiceApplicationException(String errorDescription, Throwable throwable) {

		super(APPLICATION_ERROR_CODE, errorDescription, throwable);
	}

	public ServiceApplicationException(Throwable throwable) {

		super(APPLICATION_ERROR_CODE, "Application Error", throwable);
	}
}