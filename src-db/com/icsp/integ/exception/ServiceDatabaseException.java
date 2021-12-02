/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Constants.DB_ERROR_CODE;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ServiceDatabaseException extends ServiceRuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public ServiceDatabaseException() {

		this(DB_ERROR_CODE, "Database Error");
	}

	public ServiceDatabaseException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}

	public ServiceDatabaseException(String errorCode, String errorDescription, Throwable throwable) {

		super(errorCode, errorDescription, throwable);
	}

	public ServiceDatabaseException(Throwable throwable) {

		this(DB_ERROR_CODE, "Database Error", throwable);
	}
}