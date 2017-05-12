package com.dgit.finaltest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dgit.finaltest.jdbc.DBconnection;
import com.dgit.finaltest.jdbc.JdbcUtil;

public class TableDao {
private PreparedStatement pstmt;
	
	private static TableDao instance = new TableDao();

	private TableDao() {}

	public static TableDao getInstance() {
		return instance;
	}

	public void createTable(String sql) {
		Connection con = DBconnection.getConnection();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.printf("CREATE TABLE(%s) Success! %n",sql.substring(13, sql.indexOf("(")));
		} catch (SQLException e) {
			System.out.printf("CREATE TABLE(%s) Fail! %n",	sql.substring(13, sql.indexOf("(")));
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}

	}
	
	public void createTrigger(String sql){
		Connection con = DBconnection.getConnection();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.printf("CREATE Trigger Success! %n");
		} catch (SQLException e) {
			System.out.printf("CREATE Trigger Fail! %n");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

	public void createViewTable() {
		Connection con = DBconnection.getConnection();
		String sql = "create view v_output as "
				+ "select t.tname,e.ename,e.salary,e.dcode,e.gender,e.joindate,e.tcode,d.dname,d.floor from employee e , title t ,department d";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.execute();
			System.out.printf("CREATE View Success! %n");
		} catch (SQLException e) {
			System.out.printf("CREATE View Fail! %n");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}

}
