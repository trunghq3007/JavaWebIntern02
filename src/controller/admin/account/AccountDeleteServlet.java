package controller.admin.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.AccountDAOImpl;
import entity.Account;

@WebServlet(urlPatterns = {"/admin-account-delete"})

public class AccountDeleteServlet extends HttpServlet {
	AccountDAOImpl dao = new AccountDAOImpl();
	
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String username = req.getParameter("username");
	 if(dao.deleteAccount(username)) {
		 resp.sendRedirect(req.getContextPath()+"/admin-account-list");
	 } else {
		 System.out.println("Có lỗi khi xóa account trong database!");
	 }
}
}
