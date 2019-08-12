package controller.admin.subject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.impl.SubjectDAOImpl;
import entity.Subject;

@WebServlet("/admin-subject-add")
public class SubjectAdd extends HttpServlet {
	private SubjectDAOImpl subjectDAOImpl= new SubjectDAOImpl();
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/view/admin/subjectAdd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id");
		String name=request.getParameter("name");
		String soTinStr= request.getParameter("soTin");
		String semesterStr=request.getParameter("semester");
		
		//kiem tra ID
		boolean checkID;
		Subject checkIdSubject=subjectDAOImpl.getById(id);
		if(checkIdSubject!=null) {
			checkID=false;
		}
		else {
			checkID=true;
		}
		//checkName
		
		boolean checkName;
		Subject checkNameSubject=subjectDAOImpl.getByName(name);
		if(checkNameSubject!=null) {
			checkName=false;
		}else {
			checkName=true;
		}
		
		//check so tin
		boolean checkSoTin;
		int soTin=0;
		try {
			soTin=Integer.parseInt(soTinStr);
			if(soTin>0&&soTin<7) {
				checkSoTin=true;
		}
			else {
				checkSoTin=false;
			}
		}catch (Exception e) {
			checkSoTin=false;
		}
		
		//check semester
		boolean checkSemester;
		int semester=0;
		try {
			semester=Integer.parseInt(semesterStr);
			checkSemester=true;
		}catch (Exception e) {
			checkSemester=false;
		}
		//neu thoa man tat ca cac check
		if(checkID&&checkName&&checkSoTin&&checkSemester){
			Subject subject= new Subject(id,name,soTinStr,semesterStr);
			subjectDAOImpl.insert(subject);
			response.sendRedirect("/QLDiemV2/admin-subject-list");

		}
		else{
			if(!checkID) {
				request.setAttribute("errID", 1);
			}
			if(!checkName) {
				request.setAttribute("errName", 1);
			}
			if(!checkSoTin) {
				request.setAttribute("errSoTin", 1);
			}
			if(!checkSemester) {
				request.setAttribute("errSemester", 1);
			}
			
			this.doGet(request, response);
	}

}
}
