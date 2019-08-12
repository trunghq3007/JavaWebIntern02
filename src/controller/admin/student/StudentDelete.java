package controller.admin.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import entity.Student;

@WebServlet("/admin-student-delete")
public class StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentDAO StudentDAOImpl = new StudentDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String studentId = request.getParameter("studentId");
		boolean flag = StudentDAOImpl.deleteQuery(studentId);

		if (flag == true) {

			response.sendRedirect(request.getContextPath()+"/admin-student-list");

		} else {

			printWriter.println("<script type ='text/javascript'>");
			printWriter.println("alert('Xoa khong thanh cong');");
			printWriter.println("</script>");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
