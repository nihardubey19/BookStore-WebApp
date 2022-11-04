package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.entity.Cart;

public interface CartDAO {
	public boolean addCart(Cart c) throws SQLException;

	public List<Cart> getBookByUser(int userId) throws SQLException;

	public boolean deleteBook(int bookId, int userId, int cartId) throws SQLException;
}
