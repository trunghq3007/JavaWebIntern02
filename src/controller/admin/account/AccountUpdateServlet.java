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
import entity.Student;
import sun.security.util.Password;

@WebServlet(urlPatterns = {"/admin-account-update"})

public class AccountUpdateServlet extends HttpServlet {
	AccountDAOImpl dao = new AccountDAOImpl();
	
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 RequestDispatcher dispatcher = req.getRequestDispatcher("/view/admin/AccountUpdate.jsp");
	 dispatcher.forward(req, resp);
 }	 
 
 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String studentID = req.getParameter("student_id");
		Student st = new Student(studentID);
		String password1 = req.getParameter("password1");
		String password2 = req.getParameter("password2");
		String role = req.getParameter("role");
		System.out.println(username+"  "+password1+"   "+role);
		if( !username.equals("") && !password1.equals("") && !password2.equals("")) {
			if(password1.equals(password2)) {
				Account a= new Account();
				a.setUsername(username);
				a.setPassword(password1);
				a.setRole(role);
				if(dao.updateAccount(a)) {
					resp.sendRedirect(req.getContextPath()+"/admin-account-list");
				} else {
					req.setAttribute("tb15", "Xin lỗi, đã xảy ra lỗi khi cập nhật Account vào database!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountUpdate.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb15", "Mật khẩu không khớp!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountUpdate.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb15", "Vui lòng nhập đầy đủ!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/admin/AccountUpdate.jsp");
			rd.forward(req, resp);
		}
	}
 
}
