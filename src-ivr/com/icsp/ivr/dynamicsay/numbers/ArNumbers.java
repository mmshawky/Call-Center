/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.dynamicsay.numbers;

/**
 * @author Mostafa M.Shawky
 *         May 9, 2015 2:15:50 PM
 *
 */
public class ArNumbers extends Numbers {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1396355594905322950L;
	
	/**
	 * @param number
	 * @throws Exception
	 */
	public ArNumbers(Double number) throws Exception {
	
		super(number);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.icsp.ivr.dynamicsay.numbers.Numbers#getDozensBlock(java.lang.String, java.lang.String)
	 */
	@Override
	public String getDozensBlock(String remain, String tensnumber) {
	
		if (remain == null || remain.isEmpty()) {
			return tensnumber;
		}
		return remain + " and " + tensnumber;
	}
}
