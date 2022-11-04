package com.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbutil.DBConnection;
import com.entity.BookDetails;

public class BooksDAOImp implements BooksDAO {
	public BooksDAOImp() {
		super();
	}

	@Override
	public boolean addBooks(BookDetails b) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Insert into book_details(bookName, author, price, bookCategory, status, photo, email)"
				+ " values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, b.getBookName());
		ps.setString(2, b.getAuthor());
		ps.setDouble(3, b.getPrice());
		ps.setString(4, b.getBookCategory());
		ps.setString(5, b.getStatus());
		ps.setString(6, b.getPhoto());
		ps.setString(7, b.getUserEmail());
		return ps.executeUpdate() == 1;
	}

	@Override
	public List<BookDetails> getAllBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details";
		PreparedStatement ps = conn.prepareStatement(string);
		ResultSet rs = ps.executeQuery();
		BookDetails b = null;
		while (rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));

			list.add(b);
		}
		return list;
	}

	@Override
	public BookDetails getBookById(int id) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where bookId = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		BookDetails b = new BookDetails();
		while (rs.next()) {
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
		}
		return b;
	}

	@Override
	public boolean updateEditBookById(BookDetails b) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Update book_details SET bookName=?, author=?, price=?, status=? WHERE bookId = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, b.getBookName());
		ps.setString(2, b.getAuthor());
		ps.setDouble(3, b.getPrice());
		ps.setString(4, b.getStatus());
		ps.setInt(5, b.getBookId());
		
		return ps.executeUpdate()==1;
	}

	@Override
	public boolean deleteBookById(int id) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string = "Delete from book_details where bookId = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1,id);
		
		return ps.executeUpdate()==1;
	}

	@Override
	public List<BookDetails> getNewBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where status=? and bookCategory=? order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,"Active");
		ps.setString(2,"New");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		int i = 1;
		while(rs.next() && i<=4) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
			i++;
		}
		return list;
	}

	@Override
	public List<BookDetails> getRecentBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where status=? order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,"Active");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		int i = 1;
		while(rs.next() && i<=4) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
			i++;
		}
		return list;
	}

	@Override
	public List<BookDetails> getOldBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where status=? and bookCategory=? order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,"Active");
		ps.setString(2,"Old");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		int i = 1;
		while(rs.next() && i<=4) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
			i++;
		}
		return list;
	}

	@Override
	public List<BookDetails> getAllRecentBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
		}
		return list;
	}

	@Override
	public List<BookDetails> getAllOldBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where bookCategory=? order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,"Old");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
		}
		return list;
	}

	@Override
	public List<BookDetails> getAllNewBooks() throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where bookCategory=? order by bookId DESC";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1,"New");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
		}
		return list;
	}

	@Override
	public List<BookDetails> getBookByOld(String email, String bookCategory) throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where email = ? and bookCategory = ?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, email);
		ps.setString(2, bookCategory);
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
		}
		
		return list;
	}

	@Override
	public boolean oldBookDelete(int bookId) throws SQLException {
		Connection conn = DBConnection.getConnection();
		String string  = "Delete from book_details where bookid=?";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setInt(1, bookId);
		return ps.executeUpdate()==1;
	}

	@Override
	public List<BookDetails> getBookBySearch(String search) throws SQLException {
		List<BookDetails> list = new ArrayList<>();
		Connection conn = DBConnection.getConnection();
		String string = "Select * from book_details where (bookName like ? or author like ? or bookCategory like ? and status = ?)";
		PreparedStatement ps = conn.prepareStatement(string);
		ps.setString(1, "%"+search+"%");
		ps.setString(2, "%"+search+"%");
		ps.setString(3, "%"+search+"%");
		ps.setString(4, "Active");
		BookDetails b = null;
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			b = new BookDetails();
			b.setBookId(rs.getInt(1));
			b.setBookName(rs.getString(2));
			b.setAuthor(rs.getString(3));
			b.setPrice(rs.getDouble(4));
			b.setBookCategory(rs.getString(5));
			b.setStatus(rs.getString(6));
			b.setPhoto(rs.getString(7));
			b.setUserEmail(rs.getString(8));
			list.add(b);
		}
		return list;
	}

}
