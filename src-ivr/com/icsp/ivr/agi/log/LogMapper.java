/**
 *
 */
package com.icsp.ivr.agi.log;

import com.icsp.integ.db.Mapper;

/**
 * @author MSH
 *
 */
public interface LogMapper extends Mapper {
	// public ArrayList <Entity> getLog(TransactionEntity callflowLog);
	//
	// @Insert("INSERT INTO Transaction" +
	// " (STATEMENT,EXETIME,IP, SOURCEIP, METHODNAME, MAPPINGNAME,DATABASEINFO, EXCEPTION, CALL_ID ) "
	// +
	// " VALUES ( #{statement,jdbcType=VARCHAR}, #{exetime,jdbcType=INTEGER}, #{ip,jdbcType=VARCHAR}"
	// +
	// ", #{sourceIp,jdbcType=VARCHAR}, #{methodname,jdbcType=VARCHAR}, #{mappingname,jdbcType=VARCHAR}"
	// +
	// ", #{databaseinfo,jdbcType=VARCHAR}, #{exception,jdbcType=VARCHAR}, #{call_id,jdbcType=VARCHAR})")
	// public void log(Entity callflowLog);
}