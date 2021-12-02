/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.exception;

/**
 * @author Mostafa M.Shawky
 *         May 10, 2015 11:39:58 PM
 *
 */
public class IvrException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -3511117056510161543L;
	
	/**
	 * 
	 */
	public IvrException() {
	
	}
	
	/**
	 * @param message
	 */
	public IvrException(String message) {
	
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param cause
	 */
	public IvrException(Throwable cause) {
	
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param message
	 * @param cause
	 */
	public IvrException(String message, Throwable cause) {
	
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public IvrException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
	
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
}