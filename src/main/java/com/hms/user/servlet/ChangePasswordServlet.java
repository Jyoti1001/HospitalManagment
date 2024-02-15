package com.hms.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hms.dao.DoctorDAO;
import com.hms.dao.UserDAO;
import com.hms.db.DBConnection;

@WebServlet("/userChangePassword")
public class ChangePasswordServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		int userId = Integer.parseInt(req.getParameter("userId"));
//		String oldPassword = req.getParameter("oldPassword");
//		String newPassword = req.getParameter("newPassword");
//		
//		UserDAO uDAO = new UserDAO(DBConnection.getConn());
//		//boolean f = uDAO.checkOldPassword(userId, oldPassword);
//		
//		
//		HttpSession session = req.getSession();
//		
//		if(uDAO.checkOldPassword(userId, oldPassword)) {
//			
//			if(uDAO.changePassword(userId, newPassword)) {
//				
//				session.setAttribute("successMsg", "Password Change Successfully.");
//				resp.sendRedirect("change_password.jsp");
//				
//			}else {
//				
//				session.setAttribute("errorMsg", "Something wrong on server!");
//				resp.sendRedirect("change_password.jsp");
//				
//			}
//			
//		}else {
//			session.setAttribute("errorMsg", "Old password incorrect");
//			resp.sendRedirect("change_password.jsp");
//		}
		int userId = Integer.parseInt(req.getParameter("userId"));
		String newPassword = req.getParameter("newPassword");
		String oldPassword = req.getParameter("oldPassword");

		UserDAO uDAO = new UserDAO(DBConnection.getConn());

		HttpSession session = req.getSession();

		if(uDAO.checkOldPassword(userId, oldPassword)) {

			if(uDAO.changePassword(userId, newPassword)) {
				
				session.setAttribute("successMsg", "Password change successfully.");
				resp.sendRedirect("change_password.jsp");

			} else {
				
				session.setAttribute("errorMsg", "Something went wrong on server!");
				resp.sendRedirect("change_password.jsp");

			}

		} else {
			session.setAttribute("errorMsg", "Old Password not match");
			resp.sendRedirect("change_password.jsp");

		}
		
		
	}
	
	

}
