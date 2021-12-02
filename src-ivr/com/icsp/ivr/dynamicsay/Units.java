/**
 * This Code is a private work, Create for business need, You only can take idea of technolgy but not copy it
 * Because the full copy right reserved for Intelligent Communication Services Provider Company ICSP.CO
 */
package com.icsp.ivr.dynamicsay;

import com.icsp.ivr.exception.IvrException;

import java.io.Serializable;
import java.util.List;

/**
 * @author Mostafa M.Shawky
 *         May 11, 2015 10:20:57 PM
 *
 */
public interface Units extends Serializable {
	
	public List<String> say() throws IvrException;
}
