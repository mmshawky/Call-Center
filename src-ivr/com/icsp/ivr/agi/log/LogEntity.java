package com.icsp.ivr.agi.log;

import static com.icsp.integ.util.Common.callGetFunction;
import static com.icsp.integ.util.Common.logException;
import static com.icsp.integ.util.Constants.IS_DETAILED_EXCEPTION_DESC;
import static com.icsp.integ.util.Constants.LOG_TO_FILE;
import static com.icsp.integ.util.Constants.MYSQL_ASTERISK;
import static com.icsp.ivr.util.Util.getObjectData;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Invocation;

/**
 * @author MSH
 *
 */
public class LogEntity extends ExceptionEntity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	private Invocation			invocation;
	private MappedStatement		mappedStatement;
	private String				mappingName			= "NAN";
	private String				methodName			= "NAN";
	private byte[]				result				= new byte [] { -1 };
	private String				statement			= "NAN";

	@SuppressWarnings ("unchecked")
	public LogEntity(Invocation invocation, Exception excep, long exeTime) {

		super(excep, exeTime);
		this.invocation = invocation;
		HashMap<String, Object> hashMap = getObjectData(this);
		log(MYSQL_ASTERISK, "asteriskfastagi", LogMapper.class, hashMap);
	}

	public Invocation getInvocation() {

		return invocation;
	}

	public MappedStatement getMappedStatement() {

		invocation = getInvocation();
		if (invocation != null) {
			Object[] arges = invocation.getArgs();
			mappedStatement = (MappedStatement) arges[0];
		}
		return mappedStatement;
	}

	public String getMappingname() {

		mappedStatement = getMappedStatement();
		if (mappedStatement != null) {
			mappingName = mappedStatement.getResource();
		}
		return mappingName;
	}

	public String getMappingName() {

		return mappingName;
	}

	public String getMethodname() {

		mappedStatement = getMappedStatement();
		if (mappedStatement != null) {
			methodName = mappedStatement.getId();
		}
		return methodName;
	}

	public String getMethodName() {

		return methodName;
	}

	public byte[] getResult() {

		return result;
	}

	public String getStatement() {

		invocation = getInvocation();
		if (invocation != null) {
			Object[] arges = invocation.getArgs();
			Object parameter = arges[1];
			if (parameter != null) {
				BoundSql boundSql = mappedStatement.getBoundSql(parameter);
				statement = manipulateStatment(boundSql);
			}
		}
		return statement;
	}

	/**
	 * This method for manipulate the SQL statement param ? to actual data
	 *
	 * @param boundSql
	 * @return
	 */
	private String manipulateStatment(BoundSql boundSql) {

		String newStatment = null;
		String statement = null;
		if (boundSql != null) {
			statement = boundSql.getSql();
			newStatment = statement;
			try {
				Object sourseObject = boundSql.getParameterObject();
				List<ParameterMapping> mapping = boundSql.getParameterMappings();
				for (ParameterMapping parameterMapping : mapping) {
					String prop = parameterMapping.getProperty();
					Object valueObject = callGetFunction(sourseObject, prop);
					String valueString = String.valueOf(valueObject);
					newStatment = newStatment.replaceFirst("\\?", valueString);
				}
				statement = newStatment;
			} catch (Exception e) {
				logException("Error in Statment [" + statement + "] & New Statment[" + newStatment + "]", e, LOG_TO_FILE, IS_DETAILED_EXCEPTION_DESC);
			}
		}
		return statement;
	}

	public void setInvocation(Invocation invocation) {

		this.invocation = invocation;
	}

	public void setMappedStatement(MappedStatement mappedStatement) {

		this.mappedStatement = mappedStatement;
	}

	public void setMappingName(String mappingName) {

		this.mappingName = mappingName;
	}

	public void setMethodName(String methodName) {

		this.methodName = methodName;
	}

	/*
	 * CREATE TABLE asteriskfastagi.log
	 * (
	 * DateLog TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	 * ExeTime FLOAT (20) NULL,
	 * UniqueId VARCHAR(30) NOT NULL,
	 * MappingName VARCHAR(100) NULL,
	 * MethodName VARCHAR(100) NULL,
	 * Statement VARCHAR(100) NULL,
	 * Exception VARCHAR(1000) NULL,
	 * SourceIp VARCHAR(100) NULL,
	 * Ip VARCHAR(100) NULL,
	 * Databaseinfo VARCHAR(100) NULL
	 * )
	 * ENGINE = InnoDB DEFAULT
	 * CHARACTER SET = latin1;
	 */
	public void setResult(byte[] result) {

		this.result = result;
	}

	public void setStatement(String statement) {

		this.statement = statement;
	}
}