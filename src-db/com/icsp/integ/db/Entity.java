/**
 *
 */
package com.icsp.integ.db;

import static com.icsp.integ.util.Common.getNetworkInterfaceInfo;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;

import com.icsp.integ.db.session.SqlSessionCreator;
import com.icsp.integ.db.session.SqlSessionData;
import com.icsp.integ.db.session.SqlTableData;
import com.icsp.integ.util.Common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

/**
 * @author admin
 *
 */
public class Entity implements Serializable {

	/**
	 *
	 * @author admin
	 *
	 */
	class LogThread extends Thread {

		String					connectionName;
		private Entity			entity;
		SqlSessionCreator		sessionCreator;
		SqlSession				sqlSession	= null;
		Class<? extends Mapper>	table;

		public LogThread(Entity entity, SqlSessionCreator sessionCreator, String connectionName, Class<? extends Mapper> table) {

			super("Log Thread");
			this.entity = entity;
			this.table = table;
			this.connectionName = connectionName;
			this.sessionCreator = sessionCreator;
			start();
		}

		@Override
		public void run() {

			try {
				super.run();
				sqlSession = sessionCreator.getSqlSession(connectionName);
				Mapper mapper = sqlSession.getMapper(table);
				mapper.log(entity);
			} catch (Exception e) {
				logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			}
			finally {
				sessionCreator.closeConnection(sqlSession);
			}
		}
	}

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private StringBuffer		columnsNames;
	private StringBuffer		columnsValues;
	private String				databaseinfo		= "NAN";
	private String				ip					= "NAN";
	private String				scheamName			= "NAN";
	private String				sourceIp			= "NAN";
	private String				tableName			= "NAN";

	/**
	 *
	 */
	public Entity() {

		super();
	}

	public String getColumnsNames() {

		return Common.removeLastChar(columnsNames);
	}

	public String getColumnsValues() {

		return Common.removeLastChar(columnsValues);
	}

	public String getDatabaseinfo() {

		return databaseinfo;
	}

	public String getIp() {

		ip = getNetworkInterfaceInfo();
		return ip;
	}

	public String getScheamName() {

		return scheamName;
	}

	public String getSourceIp() {

		return sourceIp;
	}

	public String getTableName() {

		return tableName;
	}

	@SuppressWarnings ({"unchecked", "removal"})
	public void log(String connectionName, String schemaName, Class<? extends Mapper> table, HashMap<String, Object>... data) {

		SqlSessionCreator sessionCreator = new SqlSessionCreator();
		SqlSessionData sessionData = null;
		try {
			sessionCreator.getSqlSession(connectionName);
			sessionCreator.addMapper(table);
			sessionData = sessionCreator.getSessionData();
			for (HashMap<String, Object> raw : data) {
				String getTableName = table.getSimpleName().replaceFirst("Mapper", "");
				SqlTableData sqlTableData = sessionData.getTableData(getTableName.toLowerCase());
				setDatabaseinfo(sqlTableData.getDatabaseinfo());
				setScheamName(sqlTableData.getSchemaName());
				setTableName(getTableName.toLowerCase());
				Map<String, String> mapColumn = sqlTableData.getColumnsInfo();
				Set<String> keySet = mapColumn.keySet();
				StringBuffer columnsNames = new StringBuffer();
				StringBuffer columnsValues = new StringBuffer();
				for (String name : keySet) {
					columnsNames = columnsNames.append(name).append(",");
					String type = mapColumn.get(name);
					if (type.startsWith("INT")) {
						Object value = raw.get(name) == null ? new Integer(0) : raw.get(name);
						columnsValues = columnsValues.append(value).append(",");
					} else if (type.startsWith("DATE")) {
						columnsValues = columnsValues.append(raw.get(name)).append(",");
					} else {
						columnsValues = columnsValues.append("'" + raw.get(name) + "'").append(",");
					}
				}
				setColumnsNames(columnsNames);
				setColumnsValues(columnsValues);
				// Create Thread to avoid any waiting in insert data
				new LogThread(this, sessionCreator, connectionName, table);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logException("Error In " + getClass().getName(), e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
		}
	}

	public void setColumnsNames(StringBuffer columnsNames) {

		this.columnsNames = columnsNames;
	}

	public void setColumnsValues(StringBuffer columnsValues) {

		this.columnsValues = columnsValues;
	}

	public void setDatabaseinfo(String databaseinfo) {

		this.databaseinfo = databaseinfo;
	}

	public void setIp(String ip) {

		this.ip = ip;
	}

	public void setScheamName(String scheamName) {

		this.scheamName = scheamName;
	}

	public void setSourceIp(String sourceIp) {

		this.sourceIp = sourceIp;
	}

	public void setTableName(String tableName) {

		this.tableName = tableName;
	}
}