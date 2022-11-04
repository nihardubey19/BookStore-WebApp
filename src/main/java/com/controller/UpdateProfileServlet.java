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

@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		register(req, resp);
	}

	private void register(HttpServletRequest req, HttpServletResponse resp) {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPhno(phno);
			
			UserDAO dao = new UserDAOImp();
			boolean result = dao.checkPassword(id, password);
			HttpSession session = req.getSession();
			if(result) {
				boolean ans = dao.updateProfile(user);
				if(ans) {
					session.setAttribute("succMsg","Profile Update Successfully");
					resp.sendRedirect("edit_profile.jsp");
				}else {
					session.setAttribute("failed","Something Wrong on Server!");
					resp.sendRedirect("edit_profile.jsp");
				}
			}else {
				session.setAttribute("failedMsg","Your Password is Incorrect");
				resp.sendRedirect("edit_profile.jsp");
			}
			
		
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		

	}
}
