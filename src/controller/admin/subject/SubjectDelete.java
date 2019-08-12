package controller.admin.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.SubjectDAOImpl;

@WebServlet("/admin-subject-delete")
public class SubjectDelete extends HttpServlet {
	private SubjectDAOImpl subjectDAOImpl;
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		subjectDAOImpl= new SubjectDAOImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		subjectDAOImpl.delete(id);
		response.sendRedirect("/QLDiemV2/admin-subject-list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
