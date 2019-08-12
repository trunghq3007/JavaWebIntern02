package controller.admin.mark;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IMarkDAO;
import dao.impl.MarkDAOImpl;
import entity.Mark;

@WebServlet(urlPatterns = "/admin-mark-list")
public class MarkList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IMarkDAO MarkDAO = new MarkDAOImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String alert = request.getParameter("alert");
		if (action != null && action.equals("delete")) {
			if (alert.equals("success")) {
				request.setAttribute("message", "Xóa thành công");
				request.setAttribute("alert", alert);
			} else {
				request.setAttribute("message", "Xóa thất bại");
				request.setAttribute("alert", alert);
			}
		} else if (action != null && action.equals("add")) {
			if (alert.equals("success")) {
				request.setAttribute("message", "Nhập điểm thành công");
				request.setAttribute("alert", alert);
			}
		} else if (action != null && action.equals("update")) {
			if (alert.equals("success")) {
				request.setAttribute("message", "Sửa điểm thành công");
				request.setAttribute("alert", alert);
			}
		}

		List<Mark> list = MarkDAO.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/markList.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
