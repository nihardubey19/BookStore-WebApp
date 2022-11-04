package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DAO.UserDAOImp;
import com.entity.User;

@WebServlet("/Adminlogin")
public class AdminLogin extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		login(req,resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String userType = req.getParameter("userType");

//			System.out.print(email+" "+password+" "+userType);
			UserDAO dao = new UserDAOImp();
			HttpSession session = req.getSession();
			User user = dao.login(email, password, userType);
			if(user!=null) {
				session.setAttribute("userObj", user);
				resp.sendRedirect("admin/home.jsp");
			}else {
				session.setAttribute("failedMsg", "Something wrong on server!");
				resp.sendRedirect("admin.jsp");
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
}
