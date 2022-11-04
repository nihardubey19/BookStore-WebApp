package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.DBConnection;
import com.entity.User;

public class UserDAOImp implements UserDAO{
	@Override
	public boolean userRegister(User user) throws SQLException{
		Connection conn = DBConnection.getConnection();
		String string = "Insert into user(name,email,phno,password,userType) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPhno());
		ps.setString(4, user.getPassword());
		ps.setString(5, user.getUserType());
		
		return ps.executeUpdate()==1;
	}

	@Override
	public User login(String email, String password, String userType) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string  = "Select * from user where email=? and password=? and userType=?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,email);
		ps.setString(2,password);
		ps.setString(3, userType);
		User user = new User();
		ResultSet rs = ps.executeQuery();
		int rows=0;
		while(rs.next()) {
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setEmail(rs.getString(3));
			user.setPassword(rs.getString(4));
			user.setAddress(rs.getString(5));
			user.setLandmark(rs.getString(6));
			user.setCity(rs.getString(7));
			user.setState(rs.getString(8));
			user.setPhno(rs.getString(9));
			user.setPincode(rs.getString(10));
			user.setUserType(rs.getString(11));
			rows++;
		}
		if(rows!=0)
			return user;
		else
			return null;
	}

	@Override
	public boolean checkPassword(int id, String password) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from user where id=? and password=?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1, id);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		
		boolean ans = false;
		while(rs.next()) {
			ans = true;
		}
		return ans;
	}

	@Override
	public boolean updateProfile(User user) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Update user set name=?, email=?, phno=? where id=?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPhno());
		ps.setInt(4, user.getId());
		
		return ps.executeUpdate()==1;
	}

	@Override
	public boolean checkUser(String email) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from user where email = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		boolean ans = true;
		while(rs.next()) {
			ans = false;
		}
		return ans;
	}

}
