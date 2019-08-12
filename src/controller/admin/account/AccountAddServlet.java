package controller.admin.account;

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

@WebServlet(urlPatterns = {"/admin-account-add"})

public class AccountAddServlet extends HttpServlet {
	AccountDAOImpl dao = new AccountDAOImpl();
	
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/AccountAdd.jsp");
	 dispatcher.forward(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		String role = req.getParameter("role");
		
		if(!username.equals("")&&!password1.equals("")&&!password2.equals("")) {
			if(!dao.CheckUsername(username)) {
				if(password1.equals(password2)) {
					Account a= new Account();
					a.setUsername(username);
					a.setPassword(password1);
					a.setRole(role);
					if(dao.InsertAccountAdmin(a)) {
						resp.sendRedirect(req.getContextPath()+"/admin-account-list");
					} else {
						req.setAttribute("tb16", "Xin lỗi, đã xảy ra lỗi khi thêm tài khoản vào database!");
						RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountAdd.jsp");
						rd.forward(req, resp);
					}
				} else {
					req.setAttribute("tb16", "Mật khẩu không khớp!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountAdd.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb16", "Username đã tồn tại!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountAdd.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb16", "Vui lòng nhập đầy đủ!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountAdd.jsp");
			rd.forward(req, resp);
		}
}
}
