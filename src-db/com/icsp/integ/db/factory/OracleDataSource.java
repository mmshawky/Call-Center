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
public class OracleDataSource extends DBCPDataSourceFactory {

	/**
	 *
	 */
	public OracleDataSource() {

		super();
		driverClass = "oracle.jdbc.OracleDriver";
		defaultTransactionIsolation = Connection.TRANSACTION_READ_COMMITTED;
		connectionInitSqls = new ArrayList<String>(1);
		connectionInitSqls.add("SELECT 1 FROM DUAL");
		validationQuery = "SELECT 1 FROM DUAL";
	}
}