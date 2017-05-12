package com.dgit.finaltest.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final ConnectionFactory instance = new ConnectionFactory();

	public static Connection getInstance() {
		return instance.createConnection();
	}
	
	private ConnectionFactory(){}
	
	private Connection createConnection(){
		Connection connection = null;
		
		String url = "jdbc:mysql://localhost:3306/ncs_erp_pka";
		String user = "user_ncs";
		String password = "user_ncs";
		
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			System.err.println("JDBC CONNECTION FACTORY ERR");
			e.printStackTrace();
		}
		
		return connection;
	}
}
