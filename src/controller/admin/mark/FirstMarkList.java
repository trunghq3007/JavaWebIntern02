package controller.admin.mark;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMarkDAO;
import dao.impl.MarkDAOImpl;
import entity.Mark;
@WebServlet(urlPatterns = {"/admin-first-mark-list"})
public class FirstMarkList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	IMarkDAO MarkDAO = new MarkDAOImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Mark> list= MarkDAO.firstMarkList();
		req.setAttribute("list",list);
		req.getRequestDispatcher("/view/admin/firstMarkList.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
