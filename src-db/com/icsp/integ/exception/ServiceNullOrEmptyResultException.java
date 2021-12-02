/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Constants.NO_DATA_FOUND_CODE;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ServiceNullOrEmptyResultException extends ServiceRuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public ServiceNullOrEmptyResultException() {

		this(NO_DATA_FOUND_CODE, "Return value Handle Null values or empty results");
	}

	public ServiceNullOrEmptyResultException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}
}