package controller.admin.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import entity.Student;



/**
 * Servlet implementation class StudentSearch
 */
@WebServlet("/StudentSearch")
public class StudentSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSearchSt(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doSearchSt(request, response);
	}
	
	
	
	public void doSearchSt(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchKey = request.getParameter("search");
//		Student student = new Student();
//		student.setName(searchKey);

		List<Student> list = new ArrayList<Student>();
		IStudentDAO iStudentDAO = new StudentDAOImpl();
		list = iStudentDAO.searchStudentbyName(searchKey);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/view/admin/searchStudent.jsp");
		request.setAttribute("list", list);
		dispatcher.forward(request, response);

	}

}
