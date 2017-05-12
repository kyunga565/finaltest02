package com.dgit.finaltest.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
		
public static void close(Statement stmt){
	if (stmt != null){
		try {
			stmt.close();
			stmt = null;
		} catch (SQLException e) { 
			e.printStackTrace();
		}	
	}
}

public static void close(ResultSet rs){
	if (rs != null){
		try {
			rs.close();
			rs = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
}

public static void close(Connection con){
	if (con != null){
		try {
			con.close();
			con = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
public static void close(ResultSet rs, Statement pstmt){
	close(rs);
	close(pstmt);
}
	
}
