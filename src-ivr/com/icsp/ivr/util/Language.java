/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.util;

/**
 * @author Mostafa M.Shawky
 *         May 9, 2015 11:45:00 AM
 *
 */
public enum Language {
	Ar(1), En(2);
	
	private int	value;
	
	private Language(int value) {
	
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public int getValue() {
	
		return value;
	}
	
	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(int value) {
	
		this.value = value;
	}
}
