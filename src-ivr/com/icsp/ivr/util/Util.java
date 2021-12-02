/**
 *
 */
package com.icsp.ivr.util;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;

/**
 * @author Mostafa M.Shawky
 */
public class Util {

	private static Logger	logger	= Logger.getLogger(Util.class);

	/**
	 * This method for fill empty object from another same object method
	 *
	 * @param source
	 * @param dis
	 * @return
	 */
	public static Object fillObject(Object source, Object dis) {

		Method[] sourceMethods = source.getClass().getMethods();
		for (int i = 0; i < sourceMethods.length; i++) {
			String name = sourceMethods[i].getName();
			if (name.startsWith("get")) {
				String fieldName = name.substring(3, name.length());
				logger.debug("---" + fieldName);
				try {
					Object result = sourceMethods[i].invoke(source);
					if ((result != null) && !fieldName.equalsIgnoreCase("class")) {
						Method disMethod = dis.getClass().getMethod("set" + fieldName, sourceMethods[i].getReturnType());
						disMethod.invoke(dis, result);
					}
				} catch (Exception e) {
					logger.info("Error In fillObject " + e.getMessage());
				}
			}
		}
		return dis;
	}

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
					logException("Error In getObjectData ", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
				}
			}
		}
		return keyValuePairs;
	}

	/**
	 * This method for check selected menu item option
	 *
	 * @param regex
	 *            user selection
	 * @return true if is valid selection and via verse
	 */
	public static boolean isValidateMenuItemSelection(String regex, char selection) {

		return isValidateMenuItemSelection(regex, String.valueOf(selection));
	}

	public static boolean isValidateMenuItemSelection(String regex, String selection) {

		if (regex != null) {
			StringBuilder bulidRegex = new StringBuilder();
			char[] regexChar = regex.toCharArray();
			for (char c : regexChar) {
				if ('*' == c) {
					bulidRegex.append("\\").append(c).append("|");
				} else {
					bulidRegex.append(c).append("|");
				}
			}
			logger.debug("bulidRegex [" + bulidRegex + "]+ regex [" + regex + "] selection [" + selection + "]");
			return String.valueOf(selection).matches(bulidRegex.toString());
		}
		logger.debug("regex [" + regex + "] selection [" + selection + "]");
		return false;
	}

	/**
	 *
	 */
	public Util() {

		super();
	}
}
