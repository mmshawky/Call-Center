/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.dynamicsay.numbers;

/**
 * @author Mostafa M.Shawky
 *         May 9, 2015 2:22:45 PM
 *
 */
public class EnNumbers extends Numbers {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -606013632130273848L;

	/**
	 * @param number
	 * @throws Exception
	 */
	public EnNumbers(Double number) throws Exception {
	
		super(number);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.icsp.ivr.dynamicsay.numbers.Numbers#getDozensBlock(java.lang.String, java.lang.String)
	 */
	@Override
	public String getDozensBlock(String remain, String tensnumber) {
	
		return tensnumber + remain;
	}
}
