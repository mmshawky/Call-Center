/**
 *
 */
package com.icsp.integ.db.factory;

import java.sql.Connection;
import java.util.ArrayList;

/**
 * @author Administrator
 *
 */
public class MySqlDataSource extends DBCPDataSourceFactory {

	/**
	 *
	 */
	public MySqlDataSource() {

		super();
		driverClass = "com.mysql.jdbc.Driver";
		defaultTransactionIsolation = Connection.TRANSACTION_SERIALIZABLE;
		connectionInitSqls = new ArrayList<String>(1);
		connectionInitSqls.add("SELECT 1");
		validationQuery = "SELECT 1";
	}
}