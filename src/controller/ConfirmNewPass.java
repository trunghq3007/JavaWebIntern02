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

@WebServlet(urlPatterns = {"/ConfirmNewPass"})

public class ConfirmNewPass extends HttpServlet {
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
			RequestDispatcher rd = req.getRequestDispatcher("/view/ConfirmNewPass.jsp");
			rd.forward(req, resp);
		}		
		System.out.println(ss.getAttribute("username")+"\t"+ss.getAttribute("password"));
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession ss = req.getSession();
		
		Account acc = (Account) ss.getAttribute("luutam2"); //chứa username, password, role
		
		Student st = (Student) ss.getAttribute("student"); //chứa email
		
		
		if(acc != null ){
			String password = acc.getPassword();
			if(req.getParameter("pass").equals(password)) {
				String username = acc.getUsername();
				String id = dao2.getStudentByUsername(username).getId();
				acc.setStudent(new Student(id));
				if(dao.updatePassword(acc) && acc.getRole().equals("student")) {
					resp.sendRedirect(req.getContextPath()+"/student-home");
					ss.setAttribute("account", acc);
					ss.removeAttribute("luutam2"); //password kích hoạt sau lần login đầu tiên sẽ hết hạn
				} 
				else if(dao.updatePassword(acc) && acc.getRole().equals("admin")){
					resp.sendRedirect(req.getContextPath()+"/admin-home");
					ss.setAttribute("account", acc);
					ss.removeAttribute("luutam2"); //password kích hoạt sau lần login đầu tiên sẽ hết hạn
				}
				else {
					req.setAttribute("tb12", "Xin lỗi, đã xảy ra lỗi khi cập nhật dữ liệu vào Database!");
					RequestDispatcher rd = req.getRequestDispatcher("/view/ConfirmNewPass.jsp");
					rd.forward(req, resp);
				}
			} else {
				req.setAttribute("tb12", "Mật khẩu không chính xác!");
				RequestDispatcher rd = req.getRequestDispatcher("/view/ConfirmNewPass.jsp");
				rd.forward(req, resp);
			}
		} else {
			req.setAttribute("tb13", "Quay lại page Quên mật khẩu để thử lại!");
			RequestDispatcher rd = req.getRequestDispatcher("/view/ConfirmNewPass.jsp");
			rd.forward(req, resp);
		}		
	}
	
}
