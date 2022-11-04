package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.DBConnection;
import com.entity.BookOrders;

public class BookOrderDAOImp implements BookOrderDAO {
	@Override
	public int getOrderNo() throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_orders";
		PreparedStatement ps = conn.prepareStatement(string);
		ResultSet rs = ps.executeQuery();
		int orderCount = 1;
		while (rs.next()) {
			orderCount++;
		}
		return orderCount;
	}

	@Override
	public boolean saveOrder(List<BookOrders> list) throws SQLException {
		boolean f = false;
		Connection conn = DBConnection.getConnection();
		String string = "Insert into book_orders(order_id, user_name, email, address, phone, book_name, author, price, payment_type) values(?,?,?,?,?,?,?,?,?)";
		conn.setAutoCommit(false);
		PreparedStatement ps = conn.prepareStatement(string);
		
		for(BookOrders b: list) {
			ps.setString(1, b.getOrderId());
			ps.setString(2, b.getUserName());
			ps.setString(3, b.getEmail());
			ps.setString(4, b.getFullAddress());
			ps.setString(5, b.getPhno());
			ps.setString(6, b.getBookName());
			ps.setString(7, b.getAuthor());
			ps.setDouble(8, b.getPrice());
			ps.setString(9, b.getPaymentType());
			ps.addBatch();
		}
		int[] count = ps.executeBatch();
		conn.commit();
		f = true;
		conn.setAutoCommit(true);
		return f;
	}

	@Override
	public List<BookOrders> getBooks(String email) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_orders where email=?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		List<BookOrders> list = new ArrayList<>();
		
		while(rs.next()) {
			BookOrders b = new BookOrders();
			b.setId(rs.getInt(1));
			b.setOrderId(rs.getString(2));
			b.setUserName(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setFullAddress(rs.getString(5));
			b.setPhno(rs.getString(6));
			b.setBookName(rs.getString(7));
			b.setAuthor(rs.getString(8));
			b.setPrice(rs.getDouble(9));
			b.setPaymentType(rs.getString(10));
			
			list.add(b);
		}
		return list;
	}

	@Override
	public List<BookOrders> getAllOrders() throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_orders";
		PreparedStatement ps = conn.prepareStatement(string);
		ResultSet rs = ps.executeQuery();
		List<BookOrders> list = new ArrayList<>();
		
		while(rs.next()) {
			BookOrders b = new BookOrders();
			b.setId(rs.getInt(1));
			b.setOrderId(rs.getString(2));
			b.setUserName(rs.getString(3));
			b.setEmail(rs.getString(4));
			b.setFullAddress(rs.getString(5));
			b.setPhno(rs.getString(6));
			b.setBookName(rs.getString(7));
			b.setAuthor(rs.getString(8));
			b.setPrice(rs.getDouble(9));
			b.setPaymentType(rs.getString(10));
			
			list.add(b);
		}
		return list;
	}

}
