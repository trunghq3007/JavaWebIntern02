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
import dao.impl.MarkDAOImpl;
import entity.Mark;
import entity.Student;
import entity.Subject;

@WebServlet("/admin-mark-update")
public class MarkUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO markDAO = new MarkDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");

		Mark mark = markDAO.find(studentId, subjectId);
		System.out.println(markDAO.find(studentId, subjectId));
		request.setAttribute("mark", mark);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/markUpdate.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");
		String firstMark = request.getParameter("firstMark");
		String secondMark = request.getParameter("secondMark");

		if (!Pattern.matches("^\\d$||^10$||^\\d\\.\\d$", firstMark) || !Pattern.matches("\\d||10||^\\d\\.\\d", secondMark)) {
			request.setAttribute("note", "Điểm có giá trị từ 0 đến 10");
			doGet(request, response);
		} else {
			Subject subject = new Subject();
			subject.setId(subjectId);
			Mark newMark;
			newMark = new Mark(new Student(studentId), subject, firstMark, secondMark);
			markDAO.updateMark(newMark);
			response.sendRedirect(request.getContextPath() + "/admin-mark-list");

		}

	}

}
