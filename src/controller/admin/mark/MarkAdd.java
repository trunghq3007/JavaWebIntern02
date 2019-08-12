package controller.admin.mark;

import java.io.IOException;
import java.io.PrintWriter;

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

@WebServlet(urlPatterns = "/admin-mark-add")
public class MarkAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO markDAO = new MarkDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && action.equals("add")) {
			String alert = request.getParameter("alert");
			if (alert != null) {
				request.setAttribute("message", "Nhập điểm không thành công");
				request.setAttribute("alert", alert);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/markAdd.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");
		String mark1 = request.getParameter("mark");
		Mark mark = markDAO.find(studentId, subjectId);
		System.out.println(markDAO.find(studentId, subjectId));

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
			response.sendRedirect(request.getContextPath() + "/admin-mark-list?action=add&alert=success");
		else
			response.sendRedirect(request.getContextPath() + "/admin-mark-add?action=add&alert=danger");

	}

}
