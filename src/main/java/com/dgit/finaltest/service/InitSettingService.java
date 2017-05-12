package com.dgit.finaltest.service;

import java.util.HashMap;
import java.util.Map;

import com.dgit.finaltest.Config;
import com.dgit.finaltest.dao.DataBaseDao;
import com.dgit.finaltest.dao.TableDao;
import com.dgit.finaltest.dao.UserDao;

public class InitSettingService extends ServiceSetting {
	private Map<String, String> TABLE_SQL = new HashMap<String, String>();

	public void initSetting() {
		createSql();
		createDataBase();
		createTable();
		createUser();
	}

	private void createSql() {
		TABLE_SQL.put("title",
				"CREATE TABLE title (tcode INT(11) NOT NULL, tname VARCHAR(10) NULL,PRIMARY KEY (tcode))");
		TABLE_SQL.put("department",
				"CREATE TABLE department (dcode INT(11) NOT NULL,dname CHAR(10) NOT NULL,floor INT(11) NULL, PRIMARY KEY (dcode))");
		TABLE_SQL.put("employee",
				"CREATE TABLE employee (eno INT(11) NOT NULL, tcode INT(11) NULL, "
				+ "ename varchar(20) not null, salary int(11) null, gender TINYINT(1) NULL,"
				+ "joindate DATE NULL, dcode INT(11) NULL, PRIMARY KEY (eno), "
				+ "FOREIGN KEY (tcode) REFERENCES title (tcode),"
				+ "FOREIGN KEY (dcode) REFERENCES department (dcode))");
	}

	private void createDataBase() {
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.createDatabase();
		dao.selectUseDatabase();
	}

	private void createTable() {
		TableDao dao = TableDao.getInstance();

		for (int i = 0; i < Config.TABLE_NAME.length; i++) {
			dao.createTable(TABLE_SQL.get(Config.TABLE_NAME[i]));
		}
		 dao.createViewTable(); 
	}

	private void createUser() {
		UserDao.getInstance().initUser();
	}
}
