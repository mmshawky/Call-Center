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
public class SqlServerDataSource extends DBCPDataSourceFactory {

	/**
	 *
	 */
	public SqlServerDataSource() {

		super();
		driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		defaultTransactionIsolation = Connection.TRANSACTION_NONE;
		connectionInitSqls = new ArrayList<String>(1);
		connectionInitSqls.add("SELECT 1");
		validationQuery = "SELECT 1";
	}
}