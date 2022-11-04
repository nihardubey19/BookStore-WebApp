package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/userlogout")
public class UserLogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logout(req, resp);
	}

	private void logout(HttpServletRequest req, HttpServletResponse resp) {
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("userObj");

			HttpSession session2 = req.getSession();
			session2.setAttribute("succMsg", "Logout Successfully");
			resp.sendRedirect("login.jsp");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
