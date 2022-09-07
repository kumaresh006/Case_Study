package com.dao;

import java.sql.*;

import com.bean.PasswordManager;

public class PasswordManagerDAO
{
	public void createTable(Connection connection) throws Exception {
		String sql = "create table Password (id int, username varchar(10) primary key, password varchar(15), login_status int)";
		Statement stmt = connection.createStatement();
		
		stmt.execute(sql);
	}
	
	public int addAdmin(Connection connection, PasswordManager pwdManager) throws SQLException {
		int rows = 0;
		
		String sql = "insert into Password values(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 1);
		ps.setString(2, pwdManager.getUserName());
		ps.setString(3, pwdManager.getPassword());
		ps.setInt(4, pwdManager.getLoginStatus());
		rows = ps.executeUpdate();
		
		return rows;
	}
	
	public int fetchIdStatus(Connection connection, PasswordManager pwdManager) throws SQLException {
		int status = 0;
		String sql = "select id from Password where username=?";
		Statement stmt = connection.createStatement();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, pwdManager.getUserName());
		
		ResultSet resultObj = stmt.executeQuery(sql);
		status = resultObj.getInt("id");
		
		return status;
	}
	
	public int fetchLoginStatus(Connection connection, PasswordManager pwdManager) throws SQLException {
		int status = 0;
		String sql = "select login_status from Password where username=?";
		Statement stmt = connection.createStatement();
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, pwdManager.getUserName());
		
		ResultSet resultObj = stmt.executeQuery(sql);
		status = resultObj.getInt("login_status");
		
		return status;
	}
	
	public int updateAdminDetails(Connection connection, PasswordManager pwdManager) throws SQLException {
		int rows = 0;
		String sql = "update Password set password=?, login_status=? where username=?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, pwdManager.getPassword());
		ps.setInt(2, 0);
		ps.setString(3, pwdManager.getUserName());
		rows = ps.executeUpdate();
		
		return rows;
	}
}
