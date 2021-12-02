/**
 *
 */
package com.icsp.integ.util;

import static com.icsp.integ.util.Constants.HISTORY_DETAILS_SEPARATOR;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_STACK_TRACE_ALL_LINES;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static com.icsp.integ.util.Constants.ONE_SECOND;
import static com.icsp.integ.util.Constants.REG_EX_IS_NUMERIC;
import static java.math.BigDecimal.ROUND_UP;
import static java.util.Calendar.DAY_OF_YEAR;
import static java.util.Calendar.getInstance;
import static java.util.regex.Pattern.compile;

import com.icsp.integ.exception.ServiceApplicationException;
import com.icsp.integ.exception.ServiceRuntimeException;
import com.icsp.ivr.agi.log.ExceptionEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author Administrator
 *
 */
public class Common {
	
	private static volatile ExecutorService	executor			= null;
	private static Pattern					landlinePattern		= compile("^((\\+|00){0,1}966){0,1}((0){0,1}(1{1,2}|[2-4|6-8]{1})\\d{7})$");
	private static Logger					logger				= Logger.getLogger(Common.class);
	private static Pattern					mobilePattern		= compile("^((\\+|00){0,1}966){0,1}((5|05)\\d{8})$");
	public static String[]					PRODUCTION_SERVERS	= { "192.168.100.1" };
	
	/**
	 *
	 * @param e
	 * @param stackLineCount
	 *            TODO
	 * @return
	 */
	public static String buildException(Throwable e, boolean isShortDesc, int... stackLineCounter) {
	
		if (e == null) {
			return "NAN";
		}
		String exceptionData = "";
		exceptionData += getCauses(e, "\n### Start Exception Builder ###", isShortDesc, stackLineCounter);
		exceptionData += "\n### End of Exception Builder ###";
		return exceptionData;
	}
	
	/**
	 *
	 */
	public static String buildSetClause(String[] whereFields, Object... whereFieldsValue) {
	
		StringBuilder setClause = new StringBuilder();
		int appendAnd = 0;
		if (whereFieldsValue.length > 0) {
			setClause.append(" SET ");
			for (int i = 0; i < whereFieldsValue.length; i++) {
				if (whereFieldsValue[i] instanceof String) {
					String string = (String) whereFieldsValue[i];
					if ((whereFieldsValue[i] != null) && !string.isEmpty()) {
						if (appendAnd > 0) {
							setClause.append(" , ");
						}
						setClause.append(whereFields[i] + " = '" + whereFieldsValue[i] + "'");
						appendAnd++;
					}
				} else if (whereFieldsValue[i] instanceof Integer) {
					Integer integer = (Integer) whereFieldsValue[i];
					if (integer != -1) {
						if (appendAnd > 0) {
							setClause.append(" , ");
						}
						setClause.append(whereFields[i] + " = " + whereFieldsValue[i]);
						appendAnd++;
					}
				}
			}
		}
		return setClause.toString();
	}
	
	/**
	 * This method build where according to field and values
	 *
	 * @param whereFields
	 * @param whereFieldsValue
	 *
	 * @return
	 */
	public static String buildWhereClause(String[] whereFields, Object... whereFieldsValue) {
	
		StringBuilder whereClause = new StringBuilder();
		int appendAnd = 0;
		String whereResultString = null;
		if ((whereFieldsValue != null) && (whereFieldsValue.length > 0)) {
			whereClause.append(" WHERE ");
			for (int i = 0; i < whereFieldsValue.length; i++) {
				if (whereFieldsValue[i] instanceof String) {
					String stringValue = (String) whereFieldsValue[i];
					if ((stringValue != null) && !stringValue.isEmpty()) {
						if (appendAnd > 0) {
							whereClause.append(" AND ");
						}
						if (stringValue.indexOf(",") != -1) {
							whereClause.append(whereFields[i] + " IN (" + stringValue + ")");
						} else {
							if (isNumeric(stringValue)) {
								whereClause.append(whereFields[i] + " IN ('" + stringValue + "')");
							} else {
								whereClause.append(whereFields[i] + " LIKE '%" + stringValue + "%'");
							}
						}
						appendAnd++;
					}
				} else if (whereFieldsValue[i] instanceof Integer) {
					Integer integer = (Integer) whereFieldsValue[i];
					if (integer != -1) {
						if (appendAnd > 0) {
							whereClause.append(" AND ");
						}
						whereClause.append(whereFields[i] + " IN (" + whereFieldsValue[i] + ")");
						appendAnd++;
					}
				} else if (whereFieldsValue[i] instanceof Long) {
					Long longVar = (Long) whereFieldsValue[i];
					if (longVar != -1) {
						if (appendAnd > 0) {
							whereClause.append(" AND ");
						}
						whereClause.append(whereFields[i] + " IN (" + whereFieldsValue[i] + ")");
						appendAnd++;
					}
				}
			}
			whereResultString = whereClause.toString();
			if (whereResultString.equalsIgnoreCase(" WHERE ")) {
				whereResultString = whereResultString.replaceAll(" WHERE ", "");
			}
		}
		return whereResultString;
	}
	
	public static Object callAnyFunction(Object source, String functionName, Class<?>... parameterTypes) throws Exception {
	
		Object object = null;
		Method sourceMethod = null;
		try {
			if ((source != null) && (functionName != null)) {
				Class<?> sourceBean = source.getClass();
				sourceMethod = sourceBean.getMethod(functionName, parameterTypes);
				object = sourceMethod.invoke(source);
			}
		} catch (Exception e) {
			logException("ERROR IN callFunction", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return object;
	}
	
	/**
	 *
	 * @param source
	 * @param name
	 * @param parameterTypes
	 * @return
	 * @throws Exception
	 */
	public static Object callGetFunction(Object source, String name, Class<?>... parameterTypes) throws Exception {
	
		Object object = null;
		Method sourceMethod = null;
		try {
			if ((source != null) && (name != null)) {
				Class<?> sourceBean = source.getClass();
				String withoutFirstChar = name.substring(1);
				String firstChar = String.valueOf(name.charAt(0));
				String changeCase = firstChar.toUpperCase();
				String actualName = "get".concat(changeCase.concat(withoutFirstChar));
				try {
					sourceMethod = sourceBean.getMethod(actualName, parameterTypes);
				} catch (Exception e) {
					changeCase = firstChar.toLowerCase();
					actualName = "get".concat(changeCase.concat(withoutFirstChar));
					sourceMethod = sourceBean.getMethod(actualName, parameterTypes);
				}
				object = sourceMethod.invoke(source);
			}
		} catch (Exception e) {
			logException("ERROR IN callFunction", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return object;
	}
	
	public static String convertListIdsToString(List<?> list) {
	
		return removeLastChar(extractListIds(list));
	}
	
	/**
	 * This method for copy fields values in other bean
	 *
	 * @param source
	 * @param target
	 * @throws Exception
	 */
	public static <T> void copyFields(T source, T target) throws Exception {
	
		Class<?> sourceBean = source.getClass();
		Class<?> targetBean = target.getClass();
		Method[] sourceMethods = sourceBean.getMethods();
		for (int i = 0; i < sourceMethods.length; i++) {
			try {
				if (sourceMethods[i].getName().startsWith("get")) {
					String targetMethodBySet = sourceMethods[i].getName();
					targetMethodBySet = targetMethodBySet.replaceFirst("get", "set");
					Object object = sourceMethods[i].invoke(source);
					if (object != null) {
						if (!"setClass".equalsIgnoreCase(targetMethodBySet)) {
							Method targetMethod = targetBean.getMethod(targetMethodBySet, sourceMethods[i].getReturnType());
							targetMethod.invoke(target, object);
						}
					}
				}
			} catch (Exception e) {
				logException("ERROR IN copyFields", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			}
		}
	}
	
	/**
	 *
	 * @param list
	 * @return
	 */
	public static StringBuffer extractListIds(List<?> list) {
	
		try {
			StringBuffer buffer = new StringBuffer();
			for (Object obj : list) {
				Method method = obj.getClass().getMethod("getId");
				buffer.append(method.invoke(obj));
				buffer.append(",");
			}
			return buffer;
		} catch (Exception e) {
			logException("ERROR IN extractListIds", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return null;
	}
	
	/**
	 * This method for fill object with values set
	 *
	 * @param targetBean
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public static Object fillObject(Object targetBean, String fieldName, Object value) {
	
		value = value == null ? "NAN" : value;
		try {
			if (fieldName != null) {
				Class<?> targetBeanClass = targetBean.getClass();
				Method targetMethod = targetBeanClass.getMethod("set" + fieldName, String.class);
				targetMethod.invoke(targetBean, value);
			}
		} catch (Exception e) {
			logException("Error in fill object", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return targetBean;
	}
	
	/**
	 *
	 */
	public static String formatDate(Calendar cal) {
	
		SimpleDateFormat sdf = null;
		String date = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (cal != null) {
			try {
				date = sdf.format(cal.getTime());
			} catch (Exception e) {
				date = null;
			}
		}
		return date;
	}
	
	/**
	 * This method for format {@link Calendar} object with given pattern
	 *
	 * @param cal
	 *            {@link Calendar} to be formated
	 * @param pattern
	 *            standard Data pattern
	 * @return formated Data by given pattern or null if error happened
	 */
	public static String formatDate(Calendar cal, String pattern) {
	
		String date = null;
		try {
			if ((cal != null) && (pattern != null)) {
				SimpleDateFormat sdf = new SimpleDateFormat(pattern);
				date = sdf.format(cal.getTime());
			}
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
		return date;
	}
	
	/**
	 *
	 * @param number
	 * @return
	 */
	public static String formatPercentage(String number) {
	
		double numberDouble = ((number != null) && !number.isEmpty()) ? Double.parseDouble(number) : 0.0;
		DecimalFormat twoDigitPrecisionDecimal = new DecimalFormat("0.00");
		try {
			number = twoDigitPrecisionDecimal.format(numberDouble);
		} catch (Exception e) {
			return number;
		}
		return number;
	}
	
	/**
	 * This method for generate UUID from MAC and current date-time
	 *
	 * @return UUID as String
	 */
	public static String generateCustomUUID() {
	
		StringBuilder sb = new StringBuilder();
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				Enumeration<InetAddress> address = networkInterface.getInetAddresses();
				while (address.hasMoreElements()) {
					InetAddress inetAddress = address.nextElement();
					if (networkInterface.isUp() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && !networkInterface.isLoopback()) {
						if (inetAddress.isSiteLocalAddress()) {
							byte[] mac = networkInterface.getHardwareAddress();
							for (int i = 0; i < mac.length; i++) {
								sb.append(String.format("%02X", mac[i]));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// ignore
		}
		sb.append(formatDate(Calendar.getInstance(), "yyMMddHHmmssSSS"));
		return sb.toString();
	}
	
	/**
	 *
	 * @param obj
	 * @return
	 * @throws java.io.IOException
	 */
	public static byte[] getBytes(Object obj) throws IOException {
	
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		bos.close();
		byte[] data = bos.toByteArray();
		return data;
	}
	
	private static String getCauses(Throwable cause, String exceptionData, boolean isShortDesc, int... eachStackLineCounter) {
	
		int lineCounter = 0;
		if (cause != null) {
			String message = cause.toString();
			exceptionData += message != null ? "\nMessage -->>" + message : "\nMessage -->> No Message found";
			if (isShortDesc) {
				return exceptionData;
			}
			StackTraceElement[] stackTraceElements = cause.getStackTrace();
			if (stackTraceElements != null) {
				int line = 0;
				if (eachStackLineCounter.length > 0) {
					line = eachStackLineCounter[0];
				}
				if (LOG_STACK_TRACE_ALL_LINES == line) {
					lineCounter = stackTraceElements.length;
				}
				for (int i = 0; i < lineCounter; i++) {
					try {
						StackTraceElement element = stackTraceElements[i];
						if (element != null) {
							String stack = element.toString();
							exceptionData += "\n" + stack;
						}
					} catch (Exception e) {
						// ignore
					}
				}
			}
			exceptionData = getCauses(cause.getCause(), exceptionData, isShortDesc, eachStackLineCounter);
			return exceptionData;
		}
		return exceptionData;
	}
	
	/**
	 *
	 * @param strings
	 * @return
	 */
	public static String getCommaString(ArrayList<String> strings) {
	
		String appender = "";
		if (strings != null) {
			for (String string : strings) {
				appender += string + ",";
			}
			appender = removeLastComma(appender);
		}
		return appender;
	}
	
	public static String getDatabaseInfo(String serverUrlString) {
	
		return (serverUrlString != null) ? serverUrlString.substring(0, serverUrlString.indexOf(";")) : serverUrlString;
	}
	
	/**
	 * This method for get difference between two dates
	 *
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int getDateDiffSec(String startDate, String endDate) {
	
		Calendar startDateCurrentcal = getInstance();
		Calendar endDateCurrentcal = getInstance();
		int diff = 0;
		try {
			startDateCurrentcal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate));
			endDateCurrentcal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate));
			long startInMils = startDateCurrentcal.getTimeInMillis();
			long endInMils = endDateCurrentcal.getTimeInMillis();
			diff = (int) (endInMils - startInMils);
			diff = diff / ONE_SECOND;
		} catch (Exception e) {
			logException("ERROR IN getDateDiffSec", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return diff;
	}
	
	/**
	 * This method receive exception and wrap it to {@link ServiceExceptionFactory}
	 *
	 * @param exception
	 * @return {@link ServiceExceptionFactory}
	 */
//	public static ServiceExceptionFactory getExceptionFactory(Exception exception) {
//	
//		ServiceRuntimeException runtimeException = getRuntimeExceptionFactory(exception);
//		ServiceError error = runtimeException.getErrorInfo();
//		return new ServiceExceptionFactory(error);
//	}
	
	/**
	 * This method for any interface IP
	 *
	 */
	public static String getNetworkInterfaceInfo() {
	
		String ipAddress = "172.20.XXX.XXX";
		try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while (networkInterfaces.hasMoreElements()) {
				NetworkInterface networkInterface = networkInterfaces.nextElement();
				Enumeration<InetAddress> address = networkInterface.getInetAddresses();
				while (address.hasMoreElements()) {
					InetAddress inetAddress = address.nextElement();
					if (networkInterface.isUp() && !networkInterface.isPointToPoint() && !networkInterface.isVirtual() && !networkInterface.isLoopback()) {
						if (inetAddress.isSiteLocalAddress()) {
							ipAddress = inetAddress.getHostAddress();
							return ipAddress;
						}
					}
				}
			}
		} catch (Exception e) {
			// No needed
		}
		return ipAddress;
	}
	
	public static Integer getNull(int value) {
	
		if (Integer.toString(value).equals("-1")) {
			return 0;
		}
		return value;
	}
	
	public static String getNull(String value) {
	
		if ((value == null) || value.equals("-1")) {
			return null;
		}
		return value;
	}
	
	/**
	 *
	 * @param source
	 * @return
	 */
	public static HashMap<String, Object> getObjectData(Object source) {
	
		LinkedHashMap<String, Object> keyValuePairs = new LinkedHashMap<String, Object>();
		Method[] sourceMethods = source.getClass().getMethods();
		for (int i = 0; i < sourceMethods.length; i++) {
			String name = sourceMethods[i].getName();
			if (name.startsWith("get")) {
				String fieldName = name.substring(3, name.length());
				try {
					Object result = sourceMethods[i].invoke(source);
					if ((result != null) && !fieldName.equalsIgnoreCase("class")) {
						keyValuePairs.put(fieldName, result);
					}
				} catch (Exception e) {
					logException("Error In getObjectData", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
				}
			}
		}
		return keyValuePairs;
	}
	
	/**
	 * This method for check if Exception is null and return adapted exception
	 *
	 * @param exception
	 * @return
	 */
	public static ServiceRuntimeException getRuntimeExceptionFactory(Throwable exception) {
	
		try {
			if (exception == null) {
				return new ServiceApplicationException();
			}
			if (exception instanceof ServiceRuntimeException) {
				return (ServiceRuntimeException) exception;
			}
			if (exception instanceof RuntimeException) {
				return new ServiceApplicationException(exception);
			}
			if (exception instanceof Exception) {
				return new ServiceApplicationException(exception);
			}
			Throwable root = exception.getCause();
			return getRuntimeExceptionFactory(root);
		} catch (Exception e) {
			return new ServiceApplicationException(e);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static float getScaleFloatPoint(double result) {
	
		float fResult = 0f;
		try {
			BigDecimal bdValue = new BigDecimal(result);
			fResult = bdValue.setScale(2, ROUND_UP).floatValue();
		} catch (Exception e) {
			logException("ERROR IN getScaleFloatPoint", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return fResult;
	}
	
	/**
	 * This method for return Singleton Executor with Lazy initialization
	 *
	 * @return
	 */
	public synchronized static ExecutorService getSingletonExecutorInstance() {
	
		try {
			if ((executor == null) || executor.isTerminated() || executor.isShutdown()) {
				logger.info("*****************  Create new ExecutorService .... ");
				executor = Executors.newCachedThreadPool();
			}
		} catch (Exception e) {
			logException("Error createing Singleton Executor Instance", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return executor;
	}
	
	/**
	 *
	 * @param strings
	 * @param founder
	 * @return
	 */
	public static ArrayList<String> isExist(ArrayList<String> strings, String founder) {
	
		if ((founder != null) && !founder.isEmpty()) {
			if (!strings.contains("'" + founder + "'")) {
				strings.add("'" + founder + "'");
			}
		}
		return strings;
	}
	
	/**
	 *
	 * @param number
	 * @return
	 */
	public static boolean isLandLineNumber(String number) {
	
		try {
			return landlinePattern.matcher(number).find();
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 *
	 * @param number
	 * @return
	 */
	public static boolean isMobileNumber(String number) {
	
		try {
			return mobilePattern.matcher(number).find();
		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean isNumeric(String str) {
	
		return str.matches(REG_EX_IS_NUMERIC);
	}
	
	/**
	 * The method check if passed IP is one of our production servers
	 *
	 * @param ip
	 * @return
	 */
	public static boolean isProductionServer() {
	
		for (String ip : PRODUCTION_SERVERS) {
			if (ip.equalsIgnoreCase(getNetworkInterfaceInfo())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 *
	 */
	public static boolean isRealTime(String startDate, String endDate) {
	
		Calendar currentcal = getInstance();
		Calendar startDateCurrentcal = getInstance();
		Calendar endDateCurrentcal = getInstance();
		try {
			startDateCurrentcal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startDate));
			endDateCurrentcal.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endDate));
			if (((startDateCurrentcal.get(DAY_OF_YEAR) == currentcal.get(DAY_OF_YEAR)) && (endDateCurrentcal.get(DAY_OF_YEAR) == currentcal.get(DAY_OF_YEAR)))) {
				return true;
			}
		} catch (Exception e) {
			logException("ERROR IN isRealTime ", e, Constants.LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		return false;
	}
	
	/**
	 *
	 * @param customNote
	 * @param param
	 */
	public static void log(String customNote, Object... param) {
	
		logger.debug(customNote);
	}
	
	/**
	 * @param customNote
	 *            TODO
	 * @param isLogDatabase
	 *            TODO
	 * @param isShortDesc
	 *            TODO
	 * @param addTrace
	 *            TODO
	 *
	 */
	public static void logException(String customNote, Exception e, boolean isLogDatabase, boolean isShortDesc, int... stackLineCounter) {
	
		if (isLogDatabase) {
			try {
				new ExceptionEntity(e, 0);
			} catch (Exception ex) {
				logException("Error in logException Function", ex, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			}
		} else {
			logger.error(customNote + "\n" + buildException(e, isShortDesc, stackLineCounter));
		}
	}
	
	/**
	 * This method for put comma and put string formated in SQL IN statement
	 *
	 * @param stringInSql
	 * @return String formated in SQL IN statement
	 */
	public static String manipulateCommaInString(String stringInSql) {
	
		if (stringInSql != null) {
			stringInSql = removeLastComma(stringInSql);
			stringInSql = stringInSql.replaceAll(",", "','");
			stringInSql = "'" + stringInSql + "'";
		}
		return stringInSql;
	}
	
	/**
	 * This Method for create array with same passed array length
	 *
	 * @param array
	 * @param length
	 *            master array length
	 * @return normalized array
	 */
	public static String[] normalizeArray(String[] array, int length) {
	
		String[] normalisedArray = new String [length];
		try {
			System.arraycopy(array, 0, normalisedArray, 0, length);
		} catch (Exception e) {
			//
		}
		return normalisedArray;
	}
	
	/**
	 *
	 */
	public static Date parseDate(String calString) {
	
		SimpleDateFormat sdf = null;
		Date date = null;
		sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (calString != null) {
			try {
				date = sdf.parse(calString);
			} catch (Exception e) {
				date = null;
			}
		}
		return date;
	}
	
	public static boolean parseOutParamAsBool(String outParam) {
	
		if (("TRUE").equalsIgnoreCase(outParam) || ("Y").equalsIgnoreCase(outParam) || ("1").equals(outParam)) {
			return true;
		}
		return false;
	}
	
	public static double parseOutParamAsDouble(String outParam) {
	
		DecimalFormat formatedVal;
		if ((outParam == null) || (outParam.isEmpty()) || ("null".equals(outParam)) || "NA".equals(outParam)) {
			return 0.0;
		}
		try {
			formatedVal = new DecimalFormat("0.00");
			return Double.parseDouble(formatedVal.format(Double.parseDouble(outParam)));
		} catch (NumberFormatException e) {
			return 0.0;
		}
	}
	
	public static int parseOutParamAsInt(String outParam) {
	
		if ((outParam == null) || (outParam.isEmpty()) || ("null".equals(outParam)) || "NA".equals(outParam)) {
			return 0;
		}
		try {
			return Integer.parseInt(outParam);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
	
	public static int parseOutParamAsInt(String outParam, int defaultVal) {
	
		if ((outParam == null) || (outParam.isEmpty()) || ("null".equals(outParam)) || "NA".equals(outParam)) {
			return defaultVal;
		}
		try {
			return Integer.parseInt(outParam);
		} catch (NumberFormatException e) {
			return defaultVal;
		}
	}
	
	public static String parseOutParamAsString(String outParam) {
	
		if (outParam == null) {
			return "";
		}
		return outParam;
	}
	
	public static String removeLastChar(StringBuffer output) /*throws ServiceApplicationException */{
	
//		try {
			if ((output != null) && (output.length() > 0) && (output.charAt(output.length() - 1) == ',')) {
				output.deleteCharAt(output.length() - 1);
				return output.toString();
			} else {
				return output.toString();
			}
//		} catch (StringIndexOutOfBoundsException e) {
//			e.printStackTrace();
//			throw new ServiceApplicationException("Can't get result from String " + output, e);
//		}
	}
	
	/**
	 * This method remove last Comma char if founded
	 *
	 * @param commaInTheEnd
	 * @return String not ended with comma
	 */
	private static String removeLastComma(String commaInTheEnd) {
	
		return (commaInTheEnd.lastIndexOf(",") != -1) ? commaInTheEnd.substring(0, commaInTheEnd.lastIndexOf(",")) : commaInTheEnd;
	}
	
	/**
	 * This method remove leading Zero from served number passed for method
	 *
	 * @param servedNumber
	 * @return served number without Zero
	 */
	public static String removeLeadingZero(String servedNumber) {
	
		if (servedNumber.startsWith("0")) {
			logger.debug("Served Number strat with 0 [" + servedNumber + "]");
			servedNumber = servedNumber.substring(servedNumber.indexOf("0") + 1);
		}
		logger.debug("After removing Zero from Served Number [" + servedNumber + "]");
		return servedNumber;
	}
	
	/**
	 *
	 * @param historyDetails
	 * @return
	 */
	public static String[] splitStringToList(String historyDetails) {
	
		String[] nodesLists = null;
		try {
			if ((historyDetails != null) && (historyDetails.length() > 0)) {
				nodesLists = historyDetails.split(HISTORY_DETAILS_SEPARATOR);
			}
		} catch (Exception e) {
			throw new ServiceApplicationException(e);
		}
		return nodesLists;
	}
	
	/**
	 * This method for convert byte with int format to String of binary
	 *
	 * @param b
	 * @return
	 */
	static public String toBinaryString(int b) {
	
		String output = "";
		for (int i = 7; i >= 0; i--) {
			if ((b - ((int) Math.pow(2.0, i))) < 0) {
				output += "0";
			} else {
				b -= ((int) Math.pow(2.0, i));
				output += "1";
			}
			output += (i == 4) ? "" : "";
		}
		return output;
	}
	
	/**
	 *
	 * @param prefix
	 * @param fieldName
	 * @return
	 */
	public static String toJavaMethodName(String prefix, String fieldName) {
	
		char firstChar = fieldName.charAt(0);
		fieldName = fieldName.substring(1);
		fieldName = fieldName.toLowerCase();
		fieldName = firstChar + fieldName;
		return prefix + fieldName;
	}
	
	/**
	 *
	 * @param tobeconverted
	 * @return
	 */
	public static String toUpperCaseFirstChar(String tobeconverted) {
	
		try {
			tobeconverted = tobeconverted.substring(0, 1).toUpperCase() + tobeconverted.substring(1);
		} catch (Exception e) {}
		return tobeconverted;
	}
	
	/**
	 *
	 */
	public Common() {
	
		super();
	}
}