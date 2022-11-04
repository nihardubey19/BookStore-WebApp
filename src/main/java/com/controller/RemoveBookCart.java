package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.CartDAO;
import com.DAO.CartDAOImp;

@WebServlet("/remove_book")
public class RemoveBookCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		removeBook(req, resp);
	}

	private void removeBook(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		try {
			int bookId = Integer.parseInt(req.getParameter("bId"));
			int userId = Integer.parseInt(req.getParameter("uId"));
			int cartId = Integer.parseInt(req.getParameter("cId"));
			CartDAO dao = new CartDAOImp();
			boolean result = dao.deleteBook(bookId, userId, cartId);
			HttpSession session = req.getSession();
			
			if(result==true) {
				session.setAttribute("succMsg", "Book Removed from Cart");
				resp.sendRedirect("checkout.jsp");
			}
			else {
				session.setAttribute("failedMsg", "Something Wrong on Server");
				resp.sendRedirect("checkout.jsp");
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
	}
 
}
