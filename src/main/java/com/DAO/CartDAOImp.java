package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbutil.DBConnection;
import com.entity.BookDetails;
import com.entity.Cart;

public class CartDAOImp implements CartDAO{

	@Override
	public boolean addCart(Cart cart) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Insert into cart(bookId, userId, bookName, author, price, totalPrice) values(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(string);
	
		ps.setInt(1, cart.getBookId());
		ps.setInt(2, cart.getUserId());
		ps.setString(3, cart.getBookName());
		ps.setString(4, cart.getAuthor());
		ps.setDouble(5, cart.getPrice());
		ps.setDouble(6, cart.getTotalPrice());
		
		return ps.executeUpdate()==1;
	}

	@Override
	public List<Cart> getBookByUser(int userId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from cart where userId=?"; 
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1, userId);
		List<Cart> list = new ArrayList<>();
		double totalPrice = 0;
		Cart c = null;
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			c = new Cart();
			c.setCartId(rs.getInt(1));
			c.setBookId(rs.getInt(2));
			c.setUserId(rs.getInt(3));
			c.setBookName(rs.getString(4));
			c.setAuthor(rs.getString(5));
			c.setPrice(rs.getDouble(6));
			totalPrice+=rs.getDouble(7);
			c.setTotalPrice(totalPrice);
			list.add(c);
		}
		return list;
	}

	@Override
	public boolean deleteBook(int bookId, int userId, int cartId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Delete from cart where bookId = ? and userId = ? and cartId = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1, bookId);
		ps.setInt(2, userId);
		ps.setInt(3, cartId);
		
		return ps.executeUpdate()==1;
	}	
	
}
