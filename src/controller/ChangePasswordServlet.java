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
import entity.Account;

@WebServlet(urlPatterns = {"/ChangePassword"})

public class ChangePasswordServlet extends HttpServlet {
	AccountDAOImpl dao = new AccountDAOImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		
		Account acc = (Account) ss.getAttribute("account");
		
		if(acc != null) { // đã đăng nhập -> tồn tại session account
			RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect(req.getContextPath()+"/Login"); 
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();

		Account account = (Account) ss.getAttribute("account");

		String currentpassword = req.getParameter("currentpassword");

		String newpassword1 = req.getParameter("newpassword1");

		String newpassword2 = req.getParameter("newpassword2");

		if(account!=null) {
			if(!currentpassword.equals("") && !newpassword1.equals("") && !newpassword2.equals("")) {
				if(account.getPassword().equals(currentpassword)) {
					if(newpassword1.equals(newpassword2)) {
						account.setPassword(newpassword1);
						ss.setAttribute("account", account);
						if(dao.updatePassword(account)) {
							req.setAttribute("tb9", "Thay đổi mật khẩu thành công. Quay về trang chủ!");
							RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
							rd.forward(req, resp);
						} else {
							req.setAttribute("tb8", "Xin lỗi, đã xảy ra lỗi khi cập nhật password trong database!");
							RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
							rd.forward(req, resp);
						}
					} else {
						req.setAttribute("tb8", "Mật khẩu mới không khớp nhau!");
						RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
						rd.forward(req, resp);
					}
				} else {
					req.setAttribute("tb8", "Sai mật khẩu hiện tại!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb8", "Vui lòng nhập đầy đủ!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/ChangePassword.jsp");
				rd.forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath()+"/Login");
		}
	}
}
