/**
 *
 */
package com.icsp.integ.exception;

import static com.icsp.integ.util.Constants.NO_MAPPING_FOUND_CODE;

/**
 * @author Mostafa M.Shawky
 *
 */
public class ServiceNullMappingResultException extends ServiceNullOrEmptyResultException {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	public ServiceNullMappingResultException() {

		this("Return Null or empty Mapping results");
	}

	public ServiceNullMappingResultException(String errorDescription) {

		this(NO_MAPPING_FOUND_CODE, errorDescription);
	}

	public ServiceNullMappingResultException(String errorCode, String errorDescription) {

		super(errorCode, errorDescription);
	}
}