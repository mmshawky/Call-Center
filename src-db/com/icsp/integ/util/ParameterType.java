/*
 * Created on Apr 5, 2009
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.icsp.integ.util;

import java.io.Serializable;

public class ParameterType implements Serializable {

	public enum ParameterTypeDefination {
		DATE, DECIMAL, DOUBLE, FLOAT, INTEGER, NUMERIC, OBJECT, TIMESTAMP, VARCHAR;
	}

	/**
	 *
	 */
	private static final long		serialVersionUID	= 1L;
	private ParameterTypeDefination	Key;
	private Object					value;

	public ParameterTypeDefination getKey() {

		return Key;
	}

	public Object getValue() {

		return value;
	}

	public void setKey(ParameterTypeDefination key) {

		Key = key;
	}

	public void setValue(Object value) {

		this.value = value;
	}

	@Override
	public String toString() {

		String dump = "";
		if (getKey() != null) {
			dump = "[" + getKey() + " = ";
		}
		if (getValue() != null) {
			dump += getValue() + "]";
		}
		return dump;
	}
}
