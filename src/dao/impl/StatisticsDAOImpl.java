package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Statistics;
import entity.Student;
import entity.Subject;
import entity.Class;

public class StatisticsDAOImpl {

	// thong ke luu ban
	public static List<Statistics> queryRepetition(Connection conn) throws SQLException {

		String sql = "select student_id, student_name, sbj.semester, c.id as class_id, class_name,\n"
					+ "SUM(first_mark * number_of_credits)/SUM(number_of_credits) as mark_avarage\n"
					+ "from mark m, student s, class c, subject sbj\n" 
					+ "where student_id = s.id\n"
					+ "and class_id = c.id\n" 
					+ "and sbj.id = subject_id\n"
					+ "group by student_id, student_name, class_name, gender, c.id, semester\n"
					+ "having SUM(first_mark * number_of_credits)/SUM(number_of_credits) < 5";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Statistics> list = new ArrayList<Statistics>();
		while (rs.next()) {
			String student_id = rs.getString("student_id");
			String student_name = rs.getString("student_name");
			String semester = rs.getString("semester");
			String class_id = rs.getString("class_id");
			String class_name = rs.getString("class_name");
			double mark_avarage = rs.getDouble("mark_avarage");

			Student student = new Student(student_id, student_name);
			Class classroom = new Class(class_id, class_name);
			Subject subject = new Subject(semester);

			Statistics statistics = new Statistics(mark_avarage, student, classroom, subject);
			list.add(statistics);
		}
		return list;
	}

	// thong ke hoc bong loai 1, 2
	public static List<Statistics> queryScholarship(Connection conn) throws SQLException {
		String sql = "select student_id, student_name, sbj.semester,  c.id as class_id,\n"
					+ "SUM(first_mark * number_of_credits)/SUM(number_of_credits) as mark_avarage\n"
					+ "from mark m, student s, class c, subject sbj\n" 
					+ "where student_id = s.id\n"
					+ "and class_id = c.id\n" 
					+ "and sbj.id = subject_id\n" 
					+ "and first_mark > 6\n"
					+ "group by student_id, student_name, class_name, gender, c.id, semester\n"
					+ "having SUM(first_mark * number_of_credits)/SUM(number_of_credits) > 7";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();
		List<Statistics> list = new ArrayList<Statistics>();
		while (rs.next()) {
			String student_id = rs.getString("student_id");
			String student_name = rs.getString("student_name");
			String semester = rs.getString("semester");
			String class_id = rs.getString("class_id");
			double mark_avarage = rs.getDouble("mark_avarage");

			Statistics statistics = new Statistics();
			Student student = new Student();
			student.setId(student_id);
			student.setName(student_name);
			statistics.setStudent(student);

			Class classroom = new Class();
			classroom.setId(class_id);
			statistics.setClassroom(classroom);

			Subject subject = new Subject();
			subject.setSemester(semester);
			statistics.setSubject(subject);

			String sql2 = "select first_mark\n" 
						+ "from mark\n" 
						+ "where student_id = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setString(1, student_id);
			ResultSet rs2 = pstm2.executeQuery();
			while (rs2.next()) {
				int first_mark = rs2.getInt("first_mark");
				if (mark_avarage > 8 && first_mark >= 7) {
					statistics.setScholarship("loại 1");
				} else if (mark_avarage > 7 && first_mark >= 6) {
					statistics.setScholarship("loại 2");
				}
			}
			statistics.setMark_avarage(mark_avarage);
			list.add(statistics);
		}
		return list;
	}

}