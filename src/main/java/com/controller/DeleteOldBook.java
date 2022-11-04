package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.BooksDAO;
import com.DAO.BooksDAOImp;

@WebServlet("/delete_old_book")
public class DeleteOldBook extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int bookId = Integer.parseInt(req.getParameter("bId"));
			BooksDAO dao = new BooksDAOImp();
			boolean result = dao.oldBookDelete(bookId);
			HttpSession session = req.getSession();
			if(result==true) {
				session.setAttribute("succMsg","Old Book Delete Successfully");
				resp.sendRedirect("old_books.jsp");
			}else {
				session.setAttribute("failedMsg", "Something Wrong on Server!");
				resp.sendRedirect("old_books.jsp");
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
