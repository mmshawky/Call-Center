package com.icsp.integ.db.session;

import java.util.HashMap;
import java.util.Map;

public class SqlTableData {

	private String				databaseinfo	= "NAN";
	private Map<String, String>	mapColumns		= new HashMap<String, String>();
	private String				schemaName		= "NAN";
	private String				tableName		= "NAN";

	public SqlTableData() {

		super();
	}

	public Map<String, String> getColumnsInfo() {

		return mapColumns;
	}

	public String getDatabaseinfo() {

		return databaseinfo;
	}

	public String getSchemaName() {

		return schemaName;
	}

	public String getTableName() {

		return tableName;
	}

	public void setColumnsInfo(String columnsName, String columnsType) {

		this.mapColumns.put(columnsName, columnsType);
	}

	public void setDatabaseinfo(String databaseinfo) {

		this.databaseinfo = databaseinfo;
	}

	public void setSchemaName(String schemaName) {

		this.schemaName = schemaName;
	}

	public void setTableName(String tableName) {

		this.tableName = tableName;
	}
}
