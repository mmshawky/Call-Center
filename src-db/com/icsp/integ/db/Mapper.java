package com.icsp.integ.db;

import org.apache.ibatis.annotations.Insert;

public interface Mapper {

	@Insert ("INSERT INTO ${scheamName}.${tableName}" + " (${columnsNames}) VALUES ( ${columnsValues})")
	public void log(Entity callflowLog);
}
