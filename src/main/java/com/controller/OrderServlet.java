package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.*;
import com.entity.*;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("username");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("payment");
			
			String fullAddress = address+","+landmark+","+city+","+state+","+pincode;
//			System.out.println(name+" "+email+" "+phno+" "+fullAddress+paymentType);
			
			HttpSession session = req.getSession();
			CartDAO dao = new CartDAOImp();
			List<Cart> list = dao.getBookByUser(id);
			
			if(list.isEmpty()) {
				session.setAttribute("failedMsg", "Please Add Items");
				resp.sendRedirect("checkout.jsp");
			}else {				
				BookOrderDAO dao2 = new BookOrderDAOImp();
				 
				int i = dao2.getOrderNo();
				
				List<BookOrders> orderList = new ArrayList<>();
				for(Cart C: list) {
					BookOrders o = new BookOrders();
					o.setOrderId("BOOK-ORD-00"+(++i)); 
					o.setUserName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setFullAddress(fullAddress);
					o.setAuthor(C.getAuthor());
					o.setBookName(C.getBookName());
					o.setPrice(C.getPrice());
					o.setPaymentType(paymentType);
					orderList.add(o);
				}
					
				if("noselect".equals(paymentType)) {	
					session.setAttribute("failedMsg", "Please Choose Payment Method");
					resp.sendRedirect("checkout.jsp");
				}else {
					boolean result = dao2.saveOrder(orderList);
					if(result) {
						System.out.println("Order success");
						resp.sendRedirect("order_success.jsp");
					}else {
						session.setAttribute("failedMsg", "Order Failed");
						resp.sendRedirect("checkout.jsp");
					}
				}
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
