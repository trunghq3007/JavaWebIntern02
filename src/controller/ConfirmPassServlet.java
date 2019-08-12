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

@WebServlet(urlPatterns = {"/ConfirmPassServlet"})

public class ConfirmPassServlet extends HttpServlet{
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
			RequestDispatcher rd = req.getRequestDispatcher("/view/Confirm_Pass.jsp");
			rd.forward(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		
		Account acc = (Account) ss.getAttribute("luutam"); //chứa username, password, role
		
		Student st = (Student) ss.getAttribute("student"); //chứa email
		
		if(acc != null ){
			String password = acc.getPassword();
			if(req.getParameter("pass").equals(password)) {
				if(dao.InsertAccountStudent(acc,st)) {
					String username = acc.getUsername();
					String id = dao2.getStudentByUsername(username).getId();
					acc.setStudent(new Student(id));
					resp.sendRedirect(req.getContextPath()+"/student-home");
					ss.setAttribute("account", acc);
					ss.removeAttribute("luutam"); //password kích hoạt sau lần login đầu tiên sẽ hết hạn
				} else {
					req.setAttribute("tb3", "Xin lỗi, đã xảy ra lỗi khi thêm dữ liệu vào Database!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/Confirm_Pass.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb3", "Mật khẩu không chính xác!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/Confirm_Pass.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb3", "Mật khẩu kích hoạt đã hết hạn!");
			req.setAttribute("tb4", "Đăng ký lại để nhận mật khẩu kích hoạt mới!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/Confirm_Pass.jsp");
			rd.forward(req, resp);
		}		
	}
}
