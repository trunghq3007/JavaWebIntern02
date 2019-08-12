package controller.admin.mark;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMarkDAO;
import dao.IStudentDAO;
import dao.ISubjectDAO;
import dao.impl.MarkDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.SubjectDAOImpl;
import entity.Mark;
import entity.Student;
import entity.Subject;

@WebServlet(urlPatterns = "/admin-mark-add")
public class MarkAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO markDAO = new MarkDAOImpl();
	IStudentDAO studentDAO = new StudentDAOImpl();
	ISubjectDAO subjectDAO = new SubjectDAOImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String action = request.getParameter("action");
//		if (action != null && action.equals("add")) {
//			String alert = request.getParameter("alert");
//			if (alert != null) {
//				request.setAttribute("message", "Nhập điểm không thành công");
//				request.setAttribute("alert", alert);
//			}
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/markAdd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");
		String mark1 = request.getParameter("mark");
		Mark mark = markDAO.find(studentId, subjectId);
		if(!Pattern.matches("\\d||10||^\\d\\.\\d", mark1)) {
			request.setAttribute("note", "Điểm có giá trị từ 0 đến 10");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/markAdd.jsp");
			dispatcher.forward(request, response);
		}
		else if(studentDAO.searchStudentbyID(studentId) == null|| subjectDAO.getById(subjectId) == null) {
			request.setAttribute("note", "Mã sinh viên hoặc mã môn học không có trong Cơ sở dữ liệu");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/markAdd.jsp");
			dispatcher.forward(request, response);
		} else {
			Subject subject = new Subject();
			subject.setId(subjectId);
			Mark newMark = new Mark(new Student(studentId), subject, mark1);
			boolean check = false;
			if (mark == null) {
				check = markDAO.insertFirstMark(newMark);
			} else {
				check = markDAO.insertSecondMark(newMark);
			}
			if (check == true)
				response.sendRedirect(request.getContextPath() + "/admin-mark-list");
			else
				response.sendRedirect(request.getContextPath() + "/admin-mark-add");
		}
		

	}

}
