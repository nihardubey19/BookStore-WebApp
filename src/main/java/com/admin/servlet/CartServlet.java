package com.admin.servlet;

import java.io.IOException;

import com.DAO.*;
import com.entity.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		cart(req,resp);
	}

	private void cart(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int bookId = Integer.parseInt(req.getParameter("bid"));
			int userId = Integer.parseInt(req.getParameter("uid"));
			String page = req.getParameter("page");
			
			BooksDAO dao = new BooksDAOImp();
			BookDetails b = dao.getBookById(bookId);
			Cart cart = new Cart();
			cart.setBookId(bookId);
			cart.setUserId(userId);
			cart.setBookName(b.getBookName());
			cart.setAuthor(b.getAuthor());
			cart.setPrice(b.getPrice());
			cart.setTotalPrice(b.getPrice());
			CartDAO dao2 = new CartDAOImp();

			HttpSession session = req.getSession();
			boolean result = dao2.addCart(cart);
			if(result==true) {
				session.setAttribute("addCart", "Book Added to Cart");
			}else {
				session.setAttribute("failed", "Something Wrong on Server");
			}			
			if(page.equals("new_page"))
				resp.sendRedirect("all_new_books.jsp");
			else if(page.equals("recent_page"))
				resp.sendRedirect("all_recent_books.jsp");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
