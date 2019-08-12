package controller;

import java.io.IOException;

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

@WebServlet(urlPatterns = { "/Login" })

public class LoginServlet extends HttpServlet {

	AccountDAOImpl dao = new AccountDAOImpl();
	StudentDAOImpl dao2 = new StudentDAOImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		Account acc = (Account) ss.getAttribute("account");
		if (acc != null && acc.getRole().equals("student")) {
			resp.sendRedirect(req.getContextPath() + "/student-home");
		} else if (acc != null && acc.getRole().equals("admin")) {
			resp.sendRedirect(req.getContextPath() + "/admin-home");
		} else {
			RequestDispatcher rd = req.getRequestDispatcher("/view/Login.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");

		String password = req.getParameter("password");

		// System.out.println(username+" "+password+" "+role+ " "+id);

		if (username != null && password != null && !username.equals("") && !password.equals("")) {
			if (dao.CheckUsername(username)) {
				Account acc = new Account();
				acc.setUsername(username);

				String id = dao2.getStudentByUsername(username).getId();
				acc.setStudent(new Student(id));

				acc.setPassword(password);

				String role = dao.getRoleOfUsername(username);
				acc.setRole(role);

				HttpSession ss = req.getSession();
				if (role.equals("student")) {
					ss.setAttribute("account", acc);
					resp.sendRedirect(req.getContextPath() + "/student-home");
				} else if (role.equals("admin")) {
					ss.setAttribute("account", acc);
					resp.sendRedirect(req.getContextPath() + "/admin-home");
				} else {
					req.setAttribute("tb6", "Sai mật khẩu!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/Login.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb6", "Username này chưa được đăng ký!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/Login.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb6", "Vui lòng nhập đầy đủ thông tin đăng nhập!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/Login.jsp");
			rd.forward(req, resp);
		}
	}
}
