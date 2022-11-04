package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DAO.UserDAOImp;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		login(req,resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String userType = req.getParameter("userType");
		
//		System.out.println(email+" "+password+" "+userType);
		UserDAO dao = new UserDAOImp();
		
		HttpSession session = req.getSession();
		try {
			User user = dao.login(email, password, userType);
			if(user!=null) {
				session.setAttribute("userObj",user);
				resp.sendRedirect("index.jsp");	
			}else {
				session.setAttribute("failedMsg", "Email and Password Invalid");
				resp.sendRedirect("login.jsp");	
			}				
			
		}catch(SQLException | IOException ex) {
			ex.printStackTrace();
		}
	}

	
}
