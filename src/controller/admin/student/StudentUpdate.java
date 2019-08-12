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
import entity.Mark;
import entity.Class;
import entity.Student;
@WebServlet("/admin-student-update")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentDAO StudentDAOImpl = new StudentDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentId = request.getParameter("studentId");

		Student sutudent = StudentDAOImpl.searchStudentbyID(studentId);
		request.setAttribute("student", sutudent);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/studentUpdate.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();

		// Thuc hien lay parameter tu trang editStudent
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birthDate = request.getParameter("birth_date");
		String birthPlace = request.getParameter("birth_place");
		String class_id = request.getParameter("class_id");

		Class class1 = new Class(class_id);
		Student student = new Student(id, name, gender, email, birthDate, birthPlace, class1);

		// Thuc hien update tra ve ket qua kieu boolean
		boolean flag = StudentDAOImpl.editQuery(student);

		if (flag == true) {
			response.sendRedirect(request.getContextPath()+"/admin-student-list");
		} else {

			printWriter.println("<script type ='text/javascript'>");
			printWriter.println("alert('Edit Failed!');");
			printWriter.println("</script>");

		}
	}

}
