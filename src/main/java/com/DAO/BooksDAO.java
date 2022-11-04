package com.DAO;

import java.sql.SQLException;
import java.util.List;

import com.entity.BookDetails;

public interface BooksDAO {
	public boolean addBooks(BookDetails b) throws SQLException;
	
	public List<BookDetails> getAllBooks() throws SQLException;
	
	public BookDetails getBookById(int id) throws SQLException;
	
	public boolean updateEditBookById(BookDetails b) throws SQLException;
	
	public boolean deleteBookById(int id) throws SQLException;
	
	public List<BookDetails> getNewBooks() throws SQLException;

	public List<BookDetails> getRecentBooks() throws SQLException;
	
	public List<BookDetails> getOldBooks() throws SQLException;
	
	public List<BookDetails> getAllRecentBooks() throws SQLException;
	
	public List<BookDetails> getAllOldBooks() throws SQLException;
	
	public List<BookDetails> getAllNewBooks() throws SQLException;
	
	public List<BookDetails> getBookByOld(String email, String bookCategory) throws SQLException;
	
	public boolean oldBookDelete(int bookId) throws SQLException;
	
	public List<BookDetails> getBookBySearch(String search) throws SQLException;
}
