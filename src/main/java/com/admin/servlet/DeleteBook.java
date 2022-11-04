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

@WebServlet("/delete_book")
public class DeleteBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		deleteBook(req, resp);
	}

	private void deleteBook(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			BooksDAO dao = new BooksDAOImp();
			boolean result = dao.deleteBookById(id);
			HttpSession session = req.getSession();
			if(result==true) {
				session.setAttribute("succMsg", "Delete Book Successfully..");
				resp.sendRedirect("admin/all_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong on Server!");
				resp.sendRedirect("admin/all_books.jsp");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
