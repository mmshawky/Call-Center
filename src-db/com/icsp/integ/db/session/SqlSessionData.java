package com.icsp.integ.db.session;

import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSessionFactory;

public class SqlSessionData {

	private HashMap<String, SqlTableData>	mapTable	= new HashMap<String, SqlTableData>();
	private SqlSessionFactory				sessionFactory;

	public SqlSessionData(SqlSessionFactory sessionFactory) {

		super();
		this.sessionFactory = sessionFactory;
		retriveSqlData();
	}

	public HashMap<String, SqlTableData> getMapTable() {

		return mapTable;
	}

	public SqlSessionFactory getSessionFactory() {

		return sessionFactory;
	}

	public SqlTableData getTableData(String tableName) {

		return mapTable.get(tableName);
	}

	private void retriveSqlData() {

		Connection connection = null;
		try {
			connection = sessionFactory.getConfiguration().getEnvironment().getDataSource().getConnection();
			String databaseinfo = "NAN";
			if (connection != null) {
				DatabaseMetaData databaseMetaData = connection.getMetaData();
				if (databaseMetaData != null) {
					databaseinfo = "Version [" + databaseMetaData.getDatabaseProductVersion() + "]-[" + databaseMetaData.getURL() + "]";
				}
				ResultSet resultSetCatalogs = databaseMetaData.getCatalogs();
				while (resultSetCatalogs.next()) {
					String schemaName = resultSetCatalogs.getString("TABLE_CAT");
					// logger.debug("-- " + schemaName);
					ResultSet resultSetTables = databaseMetaData.getTables(schemaName, null, "%", null);
					while (resultSetTables.next()) {
						SqlTableData sqlTableData = new SqlTableData();
						sqlTableData.setDatabaseinfo(databaseinfo);
						sqlTableData.setSchemaName(schemaName);
						String tableName = resultSetTables.getString("TABLE_NAME");
						sqlTableData.setTableName(tableName);
						// logger.debug("-- " + tableName);
						ResultSet resultSetColumns = databaseMetaData.getColumns(schemaName, null, tableName, null);
						while (resultSetColumns.next()) {
							String columnsName = resultSetColumns.getString("COLUMN_NAME");
							String columnsType = resultSetColumns.getString("TYPE_NAME");
							sqlTableData.setColumnsInfo(columnsName, columnsType);
							// logger.debug("---- " + columnsName + " " +
							// columnsType);
						}
						mapTable.put(sqlTableData.getTableName(), sqlTableData);
					}
				}
			}
		} catch (SQLException e) {
			logException("Error in " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		} catch (Exception e) {
			logException("Error in " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
		finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
	}

	public void setMapTable(HashMap<String, SqlTableData> mapTable) {

		this.mapTable = mapTable;
	}

	public void setSessionFactory(SqlSessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}
}