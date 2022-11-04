package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BooksDAO;
import com.DAO.BooksDAOImp;
import com.entity.BookDetails;

@WebServlet("/edit_book")
public class EditBook extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		editBooks(req, resp);
	}

	private void editBooks(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("bname");
			String author = req.getParameter("author");
			double price = Double.parseDouble(req.getParameter("price"));
			String status = req.getParameter("status");
		
			BookDetails b = new BookDetails();
			b.setBookId(id);
			b.setBookName(name);
			b.setAuthor(author);
			b.setPrice(price);
			b.setStatus(status);
			System.out.println(b);
			
			BooksDAO dao = new BooksDAOImp();
			boolean result = dao.updateEditBookById(b);
			HttpSession session = req.getSession();
			if(result==true) {
				session.setAttribute("succMsg", "Book Update Successfully..");
				resp.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on server!");
				resp.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
