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
import entity.Class;
import entity.Student;

@WebServlet("/admin-student-add")
public class StudentAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IStudentDAO StudentDAOImpl = new StudentDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/studentAdd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lay du lieu tu form nguoi dung
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String birth_date = request.getParameter("birth_date");
		String birth_place = request.getParameter("birth_place");
		String class_id = request.getParameter("class_id");

		// Dong goi doi tuong
		Class class1 = new Class(class_id);
		Student student = new Student(id, name, gender, email, birth_date, birth_place, class1);

		// Kiem tra de them sinh vien
//				boolean checkInsert = ((StudentDAOImpl.InsertQuery(student)) && (StudentDAOImpl.checkClassID(class_id))
//						&& (StudentDAOImpl.checkIDStudent(id)) && (StudentDAOImpl.checkEmail(email)));

		boolean checkInsert = ((StudentDAOImpl.InsertQuery(student)) && (StudentDAOImpl.checkClassID(class_id)));

		// && (StudentDAOImpl.checkIDStudent(id)) && (StudentDAOImpl.checkEmail(email))
//				boolean checkClassID = StudentDAOImpl.checkClassID(class_id);

		if (checkInsert == true) {
			// Neu true thi chuyen den ShowStudentServlet de xu ly hien thi
			response.sendRedirect(request.getContextPath()+"/admin-student-list");
		} else {
			// Neu false thi log canh bao
			printWriter.println("<script type ='text/javascript'>");
			printWriter.println("alert(' Invalid input!');");
			printWriter.println("</script>");
		}
	}

}
