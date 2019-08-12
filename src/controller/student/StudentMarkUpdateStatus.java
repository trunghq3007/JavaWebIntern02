package controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMarkDAO;
import dao.impl.MarkDAOImpl;
import entity.Mark;

@WebServlet("/student-mark-update-status")
public class StudentMarkUpdateStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO markDAO = new MarkDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");
		String action = request.getParameter("action");

		Mark mark = markDAO.find(studentId, subjectId);
		if (action == null) {
			System.out.println(markDAO.updateStatus(mark));
		} else if (action.equals("cancel")) {
			System.out.println(markDAO.cancelStatus(mark));
		}

		response.sendRedirect(request.getContextPath() + "/student-mark");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
