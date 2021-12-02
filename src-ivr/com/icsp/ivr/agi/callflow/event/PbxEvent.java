/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.agi.callflow.event;

import com.icsp.ivr.agi.exception.FastAgiException;

/**
 * @author Mostafa M.Shawky
 *         Apr 28, 2015 11:28:45 PM
 *
 */
public abstract class PbxEvent extends FastAgiException {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2619322359256336394L;

	/**
	 * 
	 */
	public PbxEvent() {
		super();
	}
	
	/**
	 * @param message
	 */
	public PbxEvent(String message) {
	
		super(message);
	}
	
}
