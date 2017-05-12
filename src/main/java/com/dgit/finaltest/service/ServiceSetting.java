package com.dgit.finaltest.service;

import com.dgit.finaltest.Config;

public abstract class ServiceSetting {
	 protected static String getFilePath(String tableName, boolean isImport) {
	        StringBuilder sb = new StringBuilder();
	        sb.append(isImport ? Config.IMPORT_DIR : Config.MYSQL_EXPORT_PATH).append(tableName).append(".txt");
	        return sb.toString().replace("\\", "/");
	    }   

		
		public abstract void initSetting();
}
