package controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.StatisticsDAOImpl;
import entity.Statistics;
import utils.DBUtils;

@WebServlet("/Scholarship")
public class Scholarship_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Connection conn = DBUtils.getConnection();

		List<Statistics> list = null;

		try {
			list = StatisticsDAOImpl.queryScholarship(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("ScholarshipList", list);

		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/view/admin/ScholarshipView.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
