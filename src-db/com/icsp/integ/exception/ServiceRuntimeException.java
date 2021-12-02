/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Common.buildException;
import static com.icsp.integ.util.Constants.DETAILED_EXCEPTION_LINES;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;

/**
 * @author Mostafa M.Shawky
 *
 */
public abstract class ServiceRuntimeException extends RuntimeException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= -4985627812663125895L;
	private ServiceError		serviceError;

	public ServiceRuntimeException(String errorCode, String errorDescription) {

		this(errorCode, errorDescription, null);
	}

	public ServiceRuntimeException(String errorCode, String errorDescription, Throwable throwable) {

		super("Error Code [" + errorCode + "] Cause [" + errorDescription + "]", throwable);
		this.serviceError = new ServiceError();
		this.serviceError.setErrorDescription(buildException(throwable, IS_DETAILED_EXCEPTION_DESC, DETAILED_EXCEPTION_LINES));
		this.serviceError.setErrorCode(errorCode);
	}

	public ServiceError getErrorInfo() {

		return serviceError;
	}
}