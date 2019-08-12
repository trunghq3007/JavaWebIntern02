package controller;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

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
@WebServlet(urlPatterns = {"/AccountsServlet"})

public class AccountsServlet extends HttpServlet {
	StudentDAOImpl dao = new StudentDAOImpl();
	AccountDAOImpl dao2 = new AccountDAOImpl();

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
			RequestDispatcher rd = req.getRequestDispatcher("/view/Register.jsp");
			rd.forward(req, resp);
		}		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Account acc = new Account();
		Student st = new Student();

		String email = req.getParameter("email").trim();
		st.setEmail(email);

		String username = req.getParameter("username").trim();
		acc.setUsername(username);

		int pass = new Random().nextInt();
		String password = ""+pass;
		acc.setPassword(password);

		acc.setRole("student");

		if(!username.equals("")&&!email.equals("")) {
			if(dao2.CheckUsername(username)==false) { //username chưa có ai đăng ký
				if(dao.CheckEmail(email)==true) { //email đã có trong database
					if(dao.CheckEmailRegisred(email)==false) { //email chưa kích hoạt tài khoản
						try {
							SendMail.sendMail(email, username, password);
							HttpSession ss = req.getSession();
							ss.setAttribute("luutam", acc);
							ss.setAttribute("student", st);
							resp.sendRedirect(req.getContextPath()+"/ConfirmPassServlet");
						} catch (Exception e) {
							e.printStackTrace();
						}
					} else {
						req.setAttribute("tb", "Email đã kích hoạt tài khoản!");
						RequestDispatcher rd = req.getRequestDispatcher("/view/Register.jsp");
						rd.forward(req, resp);
					}
				} else {
					req.setAttribute("tb", "Email này không được đăng ký để nhận mật khẩu!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/Register.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb", "Username đã tồn tại!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/Register.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb", "Vui lòng nhập đầy đủ!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/Register.jsp");
			rd.forward(req, resp);
		}
	}
}
