package com.dao;

import java.sql.*;


import com.bean.Operator;

public class OperatorDAO
{
	public void createTable(Connection connection) throws SQLException {
		String sql = "create table Operator (id int, first_name varchar(20), last_name varchar(20), email_ID varchar(40), phone_number varchar(20), start_shift_time varchar(8), end_shift_time varchar(8), maximum_customer int, creation_date varchar(11))";
		Statement stmt = connection.createStatement();
		stmt.execute(sql);
	}
	
	public int insertOperatorDetails(Connection connection, Operator operator) throws SQLException {
		int rows = 0;
		
		String sql = "insert into Operator values(?,?,?,?,?,?,?,?,?)";
		java.sql.PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, 2);
		ps.setString(2, operator.getFirstName());
		ps.setString(3, operator.getLastName());
		ps.setString(4, operator.getEmailId());
		ps.setString(5, operator.getPhoneNumber());
		ps.setInt(6, operator.getShiftTimeStart());
		ps.setInt(7, operator.getShiftTimeEnd());
		ps.setInt(8, operator.getMaxCustomer());
		ps.setString(9, operator.getCreationDate());
		
		rows = ps.executeUpdate();
		return rows;
	}
}
