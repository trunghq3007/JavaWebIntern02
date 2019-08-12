package dao;

import java.util.List;

import entity.Student;

public interface IStudentDAO {
	boolean CheckEmail(String email);

	boolean CheckEmailRegisred(String email);

	String getUsernameOfEmail(String email);

	Student getStudentByUsername(String username);

	List<Student> queryStudent();

	boolean InsertQuery(Student newSV);

	boolean editQuery(Student updateSV);

	boolean deleteQuery(String maSV);

	Student searchStudentbyID(String studentId);

	List<Student> searchStudentbyName(String name);

	boolean checkClassID(String classID);

	boolean checkIDStudent(String studentID);

	boolean checkEmail(String email);
}
