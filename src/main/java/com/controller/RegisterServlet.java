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

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		register(req, resp);

	}

	private void register(HttpServletRequest req, HttpServletResponse resp) {
		String name = req.getParameter("fname");
		String email = req.getParameter("email");
		String phno = req.getParameter("phno");
		String password = req.getParameter("password");
		String check = req.getParameter("checkBox");
		String userType = req.getParameter("userType");
		
		UserDAO dao = new UserDAOImp();	
		HttpSession session = req.getSession();	
		try {
			if (check == null) {
				//System.out.print("Please check Agree Terms and Conditions");
				session.setAttribute("failedMsg", "Please check Agree Terms and Conditions");
				resp.sendRedirect("register.jsp");
			} else {
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPhno(phno);
				user.setPassword(password);
				user.setUserType(userType);
				
				boolean f = dao.checkUser(email);
				if(f) {
					boolean ans = dao.userRegister(user);
					if (ans == true) {
						//System.out.print("User Register Successfully");
						session.setAttribute("succMsg", "Registration Successfully");
						resp.sendRedirect("register.jsp");
					}else {
						// System.out.print("Something wrong on server");
						session.setAttribute("failedMsg", "Something wrong on server");
						resp.sendRedirect("register.jsp");
					}
				}
				else {
					session.setAttribute("failedMsg", "User Already Exist!");
					resp.sendRedirect("register.jsp");
				}
				
			}
		}
		catch(IOException | SQLException ex) {
			ex.printStackTrace();
		}
		
	}
}