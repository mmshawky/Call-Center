/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.dynamicsay.digits;

import com.icsp.ivr.dynamicsay.Units;
import com.icsp.ivr.exception.IvrException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mostafa M.Shawky
 *         May 11, 2015 10:24:46 PM
 *
 */
public class Digits implements Units {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -4619987097427111335L;
	private String				digits;
	private final String[]		NATURAL_DIGITS		= { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	
	/**
	 * 
	 */
	public Digits(String digits) {
	
		super();
		this.digits = digits;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.icsp.ivr.dynamicsay.Units#say()
	 */
	@Override
	public List<String> say() throws IvrException {
	
		ArrayList<String> digitsList = new ArrayList<String>(2);
		// String digitString = getDigits();
		try {
			Integer.valueOf(this.digits);
		} catch (NumberFormatException e) {
			throw new IvrException("This String not present correct integer format # " + e);
		}
		char[] digits = this.digits.toCharArray();
		for (int i = 0; i < digits.length; i++) {
			String digitValue = (digits[i] + "").trim();
			String digitToSay = NATURAL_DIGITS[Integer.valueOf(digitValue)];
			digitsList.add(digitToSay);
		}
		return digitsList;
	}
	
	/**
	 * @return the digits
	 */
	public String getDigits() {
	
		return digits;
	}
	
	/**
	 * @param digits
	 *            the digits to set
	 */
	public void setDigits(String digits) {
	
		this.digits = digits;
	}
}