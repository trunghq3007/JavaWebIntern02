package controller.admin.mark;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMarkDAO;
import dao.impl.MarkDAOImpl;

@WebServlet("/admin-mark-delete")
public class MarkDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO markDAO = new MarkDAOImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String studentId = request.getParameter("studentId");
		String subjectId = request.getParameter("subjectId");
		markDAO.delete(studentId, subjectId);
		response.sendRedirect(request.getContextPath() + "/admin-mark-list");

	}

}
