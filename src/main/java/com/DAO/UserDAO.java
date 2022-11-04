package com.DAO;

import java.sql.SQLException;

import com.entity.User;

public interface UserDAO {
	public boolean userRegister(User user) throws SQLException;
	
	public User login(String email, String password, String userType) throws SQLException;

	public boolean checkPassword(int id, String password) throws SQLException;
	
	public boolean updateProfile(User user) throws SQLException;

	public boolean checkUser(String email) throws SQLException;
}
