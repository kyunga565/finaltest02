package com.dgit.finaltest.service;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.dgit.finaltest.Config;
import com.dgit.finaltest.dao.DataBaseDao;
import com.dgit.finaltest.jdbc.DBconnection;
import com.dgit.finaltest.jdbc.JdbcUtil;

public class ExportSettingService extends ServiceSetting {
	public void initSetting() {
		DataBaseDao dao = DataBaseDao.getInstance();
		dao.selectUseDatabase();

		checkBackupDir();

		for (String tableName : Config.TABLE_NAME) {
			executeExportData(getFilePath(tableName, false), tableName);
		}
		copyFile();
	}

	private void checkBackupDir() {
		File BackupDir = new File(Config.EXPORT_DIR);
		if (BackupDir.exists()) {
			for (File file : BackupDir.listFiles()) {
				file.delete();
				System.out.printf("%s Delete Success! %n", file.getName());
			}
		} else {
			BackupDir.mkdir();
			System.out.printf("%s make dir Success! %n", Config.EXPORT_DIR);
		}

	}

	private void copyFile() {
		File srcDir = new File(Config.MYSQL_EXPORT_PATH);
		File destDir = null;

		for (File file : srcDir.listFiles()) {
			destDir = new File(Config.EXPORT_DIR + file.getName());
			file.renameTo(destDir);
			file.delete();
		}
	}

	public void executeExportData(String tablePath, String tableName) {
		String sql = String.format("select * into outfile '%s' " + "character set 'UTF8' " + "fields TERMINATED by ',' "
				+ "LINES TERMINATED by '\n' from %s", tablePath, tableName);

		Statement stmt = null;
		try {
			Connection con = DBconnection.getConnection();
			stmt = con.createStatement();
			stmt.executeQuery(sql);
			System.out.printf("Export Table(%s) %d Rows Success! %n", tableName, stmt.getUpdateCount());
		} catch (SQLException e) {
			System.out.printf("error %d : %s %n", e.getErrorCode(), e.getMessage());
		} finally {
			JdbcUtil.close(stmt);
		}
	}
}
