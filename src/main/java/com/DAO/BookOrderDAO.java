package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.entity.BookOrders;

public interface BookOrderDAO {
	public int getOrderNo() throws SQLException;
	
	public boolean saveOrder(List<BookOrders> list) throws SQLException;  
	
	public List<BookOrders> getBooks(String email) throws SQLException;
	
	public List<BookOrders> getAllOrders() throws SQLException;
	
}
