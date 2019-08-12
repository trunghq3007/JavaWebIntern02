package utils;

import dao.impl.MarkDAOImpl;
import dao.impl.StudentDAOImpl;
import dao.impl.SubjectDAOImpl;

public class Main {

	public static void main(String[] args) {
		System.out.println(DBUtils.getConnection());
		//StudentDAOImpl studentDAO = new StudentDAOImpl();
		//studentDAO.findAll().forEach(sv -> System.out.println(sv.toString()));
		
		SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
		subjectDAO.findAll().forEach(sv -> System.out.println(sv.toString()));
		
		MarkDAOImpl markDAO = new MarkDAOImpl();
		markDAO.findAll().forEach(sv -> System.out.println(sv.toString()));
	}
}
