package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.AccountDAOImpl;
import dao.impl.StudentDAOImpl;
import entity.Account;
import entity.Student;
import utils.SendMail;

@WebServlet(urlPatterns = {"/Forgot_Password"})

public class Forgot_Password extends HttpServlet{
	AccountDAOImpl dao = new AccountDAOImpl();
	StudentDAOImpl dao2 = new StudentDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		Account acc = (Account) ss.getAttribute("account");
		if(acc != null && acc.getRole().equals("student")) {
			resp.sendRedirect(req.getContextPath()+"/student-home");		
		}
		else if(acc != null && acc.getRole().equals("admin")) {
			resp.sendRedirect(req.getContextPath()+"/admin-home");	
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/view/Forgot-password.jsp");
			rd.forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		Account acc = new Account();
		
		String email = req.getParameter("email").trim();
		
		if(dao2.CheckEmail(email)) {
			if(dao2.CheckEmailRegisred(email)) {
				try {
					String username = dao2.getUsernameOfEmail(email);
					acc.setUsername(username);
					
					String role = dao.getRoleOfUsername(username);
					acc.setRole(role);
					
					int pass = new Random().nextInt();
					String password = ""+pass;
					acc.setPassword(password);
					
					SendMail.sendMail(email,username,password);
					ss.setAttribute("luutam2", acc);
					resp.sendRedirect(req.getContextPath()+"/ConfirmNewPass");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				req.setAttribute("tb10", "Email này chưa được kích hoạt tài khoản!");
				req.setAttribute("tb11", "Đăng ký để kích hoạt tài khoản ngay!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/Forgot-password.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb10", "Email này không đăng ký để kích hoạt tài khoản!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/Forgot-password.jsp");
			rd.forward(req, resp);
		}
	}
}
