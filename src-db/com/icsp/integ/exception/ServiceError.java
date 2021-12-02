/**
 *
 */
package com.icsp.integ.exception;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class ServiceError implements Serializable {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	/**
	 *
	 */
	private String				errorCode;
	private String				errorDescription;

	public ServiceError() {

		super();
	}

	public ServiceError(String errorCode, String errorDescription) {

		this.errorCode = errorCode;
		this.errorDescription = errorDescription;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {

		return errorCode;
	}

	/**
	 * @return the errorDescription
	 */
	public String getErrorDescription() {

		return errorDescription;
	}

	/**
	 * @param errorCode
	 *            the errorCode to set
	 */
	public void setErrorCode(String errorCode) {

		this.errorCode = errorCode;
	}

	/**
	 * @param errorDescription
	 *            the errorDescription to set
	 */
	public void setErrorDescription(String errorDescription) {

		this.errorDescription = errorDescription;
	}
}
