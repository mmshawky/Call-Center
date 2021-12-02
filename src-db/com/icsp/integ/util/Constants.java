/**
 *
 */
package com.icsp.integ.util;

import java.io.Serializable;

/**
 * @author MSH
 *
 */
public class Constants implements Serializable {

	public static final int		AGENT_TERMINATE_CALL		= 1;
	public static final String	APPLICATION_ERROR_CODE		= "1";
	public static final int		CUSTOMER_TERMINATE_CALL		= 2;
	public static final String	DB_ERROR_CODE				= "2";
	public static final Integer	DECRYPT						= 2;
	public static final Integer	DELETE						= 3;
	public static final int		DETAILED_EXCEPTION_LINES	= 6;
	public static final int		DETAILS						= 0;
	public static final int		DETAILS_FAULTS				= 2;
	public static final String	GENERAL_ERROR_CODE			= "9";
	public static final int		GENERAL_FAILURE				= 99;
	public static final int		GSM_SERVICE_CONNECTED		= 9;
	public static final String	HISTORY_DETAILS_SEPARATOR	= ";";
	public static final Integer	INSERT						= 1;
	public static final String	INSERT_DEFAULT_TYPE			= "A";
	public static final int		INSERT_THREAD_TIMEOUT		= 13;
	public static final boolean	IS_DETAILED_EXCEPTION_DESC	= false;
	public static final boolean	IS_SHORT_EXCEPTION_DESC		= true;
	public static final boolean	LOG_CUSTOME_TRACE			= false;
	public static final boolean	LOG_STACK_TRACE				= true;
	public static final int		LOG_STACK_TRACE_ALL_LINES	= -1;
	public static final int		LOG_STACK_TRACE_LINES_COUNT	= 7;
	public static final boolean	LOG_TO_DB					= true;
	public static final boolean	LOG_TO_FILE					= false;
	public static final short	MAXIMUM_TRIES				= 3;
	public static final String	MYSQL_ASTERISK				= "mysql_asterisk";
	public static final int		NETWORK_TERMINATE_ISSUE		= 3;
	public static final int		NO_DATA_FOUND				= 2;
	public static final String	NO_DATA_FOUND_CODE			= "4";
	public static final String	NO_MAPPING_FOUND_CODE		= "5";
	public static final int		NON_TERMINATE_CALL			= 0;
	public static final int		NUM_OF_CERT_RECORD_ITEMS	= 4;
	public static final String	NUM_OF_CURR_TRY_PROC_INDEX	= "10";
	public static final int		ONE_SECOND					= 1000;
	public static final int		ONE_MINUTE					= 60 * ONE_SECOND;
	public static final String	PACKAGE_RESTRICT_LOGGING	= "com.ist";
	public static final String	REG_EX_IS_NUMERIC			= "\\d+";
	public static final int		RMI_TIMEOUT					= 5;
	public static final int		SELECT_THREAD_TIMEOUT		= 13;
	/**
	 *
	 */
	private static final long	serialVersionUID			= 1L;
	public static final String	SERVICE_SEGMENT_SEPARATOR	= ",";
	public static final String	SERVICE_STATUS_SEPARATOR	= ":";
	public static final String	TIME_OUT_ERROR_CODE			= "6";
	public static final Integer	UPDATE						= 2;
}