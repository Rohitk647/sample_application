package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.demo.to.UserDetails;
import com.demo.util.ConnectionProvider;

public class UserDetailsDAO {

	public UserDetails authenticate(String userName, String password) {

		Connection connection = ConnectionProvider.getConnection();
		
		UserDetails userDetails = null;

		String sql = "select * from user_details where emailId = ? and password = ?";

		try {

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, userName);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				userDetails = new UserDetails();
				
				userDetails.setUserId(rs.getInt("userId"));
				userDetails.setValidUser(true);
				userDetails.setName(rs.getString("name"));
				userDetails.setEmailId(rs.getString("emailId"));
				userDetails.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return userDetails;
	}

	public boolean addUser(UserDetails userDetails) {

		Connection connection = ConnectionProvider.getConnection();

		String sql = "INSERT INTO user_details (name, emailId, password) VALUES (?,?,?)";

		try {

			PreparedStatement ps = connection.prepareStatement(sql);
			
			ps.setString(1, userDetails.getName());
			ps.setString(2, userDetails.getEmailId());
			ps.setString(3, userDetails.getPassword());

			if(ps.executeUpdate() > 0) {
				
				return true;
			}

		} catch (Exception e) {

			System.out.println(e.getMessage());
		}
		
		return false;
	}
}
