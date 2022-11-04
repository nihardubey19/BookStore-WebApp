package com.admin.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.DAO.BooksDAO;
import com.DAO.BooksDAOImp;
import com.entity.BookDetails;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addBooks(req, resp);
	}

	private void addBooks(HttpServletRequest req, HttpServletResponse resp) {

		try {
			String bookName = req.getParameter("bname");
			String author = req.getParameter("author");
			double price = Double.parseDouble(req.getParameter("price"));
			String categories = req.getParameter("categories");
			String status = req.getParameter("status");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			String email = req.getParameter("email");

			BookDetails b = new BookDetails(bookName, author, price, categories, status, fileName, email);
			BooksDAO dao = new BooksDAOImp();
			boolean result = dao.addBooks(b);
			HttpSession session = req.getSession();
			
			if (result == true) {
				String path = getServletContext().getRealPath("") + "book"; // path-> contains real path where our file
																			// is to be present
				System.out.println(path);
				part.write(path + File.separator + fileName);
				session.setAttribute("succMsg", "Book Add Successfully");
				resp.sendRedirect("admin/add_books.jsp");
			} else {
				session.setAttribute("failedMsg", "Something wrong on Server");
				resp.sendRedirect("admin/add_books.jsp");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
