package com.icsp.ivr.agi.callflow.db;

import static com.icsp.integ.util.Constants.MYSQL_ASTERISK;
import static com.icsp.ivr.util.Util.getObjectData;

import com.icsp.integ.db.Entity;
import com.icsp.ivr.agi.callflow.node.PbxNode;
import com.icsp.ivr.agi.callflow.node.PbxNodesManager;

import java.util.HashMap;
import java.util.List;

public class CallflowEntity extends Entity {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	@SuppressWarnings ("unchecked")
	public CallflowEntity(PbxNodesManager manager) {

		List<PbxNode> nodes = manager.getCallHistory();
		HashMap<String, Object>[] list = new HashMap [nodes.size()];
		for (int i = 0; i < nodes.size(); i++) {
			list[i] = getObjectData(nodes.get(i));
		}
		log(MYSQL_ASTERISK, "asteriskfastagi", CallflowMapper.class, list);
	}
	/*
	 * CREATE TABLE asteriskcallflow.callflow
	 * (
	 * UniqueId VARCHAR(30) NOT NULL,
	 * Id VARCHAR(100) NULL ,
	 * MaxEntered INT(5) NULL,
	 * MinEntered INT(5) NULL ,
	 * InvalidInputPrompt VARCHAR(100) NULL DEFAULT NULL ,
	 * InvalidInputURI VARCHAR(100) NULL DEFAULT NULL ,
	 * NoInputPrompt VARCHAR(100) NULL DEFAULT NULL ,
	 * UserInput VARCHAR(30) NULL DEFAULT NULL ,
	 * Input VARCHAR(30) NULL DEFAULT NULL ,
	 * InputTimeout INT(5) NULL,
	 * MaxInvalidInput INT(5) NULL,
	 * MaxNoInput INT(5) NULL,
	 * MaxInvalidSelectionURI VARCHAR(100) NULL DEFAULT NULL ,
	 * InvalidSelectionPrompt VARCHAR(100) NULL DEFAULT NULL ,
	 * MaxNoSelectionURI VARCHAR(100) NULL DEFAULT NULL ,
	 * NoSelectionPrompt VARCHAR(100) NULL DEFAULT NULL ,
	 * MaxInvalidSelection INT(5) NULL ,
	 * MaxNoSelection INT(3) NULL ,
	 * SelectedOption INT(3) NULL ,
	 * PressTimout INT(5) NULL ,
	 * EndCallReason VARCHAR(30) NULL
	 * )
	 * ENGINE = InnoDB DEFAULT
	 * CHARACTER SET = latin1;
	 */
}