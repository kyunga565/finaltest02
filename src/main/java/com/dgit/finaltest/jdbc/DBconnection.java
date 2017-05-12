package com.dgit.finaltest.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dgit.finaltest.Config;

public class DBconnection {
	private static DBconnection instance = new DBconnection();
	private static Connection con;
	
	private DBconnection() {
		try {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(Config.URL, Config.USER, Config.PWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		if (instance == null) {
			new DBconnection();
		}
		return DBconnection.con;
	}
	
	public static void closeConnection(){
		if (con != null){
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
