package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.Type;

import dao.IMarkDAO;
import entity.Class;
import entity.Mark;
import entity.Student;
import entity.Subject;
import utils.DBUtils;

public class MarkDAOImpl implements IMarkDAO {

	@Override
	public List<Mark> findAll() {
		List<Mark> list = new ArrayList<Mark>();
		String sql = "SELECT * FROM mark \r\n" + "JOIN student ON student.id = mark.student_id\r\n"
				+ "JOIN subject ON subject.id = mark.subject_id";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String studentId = rs.getString("student_id");
				String studentName = rs.getString("student_name");
				Student student = new Student(studentId, studentName);

				String subjectId = rs.getString("subject_id");
				String subjectName = rs.getString("subject_name");
				String semester = rs.getString("semester");
				Subject subject = new Subject(subjectId, subjectName, semester);

				String firstMark = rs.getString("first_mark");
				String secondMark = rs.getString("second_mark");
				String status = rs.getString("status");

				Mark mark = new Mark(student, subject, firstMark, secondMark, status);
				list.add(mark);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public boolean insertFirstMark(Mark newMark) {
		String sql = "INSERT INTO mark (student_id, subject_id, first_mark) VALUES (?, ?, ?)";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, newMark.getStudent().getId());
			statement.setString(2, newMark.getSubject().getId());
			statement.setFloat(3, Float.parseFloat(newMark.getFirstMark()));

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertSecondMark(Mark newMark) {
		String sql = "UPDATE mark SET second_mark = ? WHERE student_id = ? AND subject_id = ?";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(2, newMark.getStudent().getId());
			statement.setString(3, newMark.getSubject().getId());
			statement.setFloat(1, Float.parseFloat(newMark.getFirstMark()));

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(String studentId, String subjectId) {
		String sql = "DELETE FROM mark WHERE student_id = ? AND subject_id = ?";
		Connection connection = DBUtils.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, studentId);
			statement.setString(2, subjectId);

			boolean rowDeleted = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowDeleted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateMark(Mark mark) {
		String sql = "UPDATE mark SET first_mark = ?, second_mark = ?, status = NULL WHERE student_id = ? AND subject_id = ?";
		Connection connection = DBUtils.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, Float.parseFloat(mark.getFirstMark()));
			if (mark.getSecondMark() != "")
				statement.setFloat(2, Float.parseFloat(mark.getSecondMark()));
			else
				statement.setNull(2,  java.sql.Types.FLOAT);
			statement.setString(3, mark.getStudent().getId());
			statement.setString(4, mark.getSubject().getId());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Mark find(String studentId, String subjectId) {
		String sql = "SELECT * FROM mark " + "JOIN student ON student.id = mark.student_id "
				+ "JOIN subject ON subject.id = mark.subject_id " + "WHERE student_id = ? AND subject_id = ?";
		Connection connection = DBUtils.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, studentId);
			ps.setString(2, subjectId);

			Mark mark = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String studentId1 = rs.getString("student_id");
				String studentName = rs.getString("student_name");
				Student student = new Student(studentId1, studentName);

				String subjectId1 = rs.getString("subject_id");
				String subjectName = rs.getString("subject_name");
				String semester1 = rs.getString("semester");
				Subject subject = new Subject(subjectId1, subjectName, semester1);

				String firstMark = rs.getString("first_mark");
				String secondMark = rs.getString("second_mark");
				String status = rs.getString("status");

				mark = new Mark(student, subject, firstMark, secondMark, status);
			}
			rs.close();
			ps.close();
			connection.close();
			return mark;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Mark> findAll(String studentId) {
		List<Mark> list = new ArrayList<Mark>();
		String sql = "SELECT * FROM mark \r\n" + "JOIN student ON student.id = mark.student_id\r\n"
				+ "JOIN subject ON subject.id = mark.subject_id \r\n" + "WHERE student_id = ?";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, studentId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String studentId1 = rs.getString("student_id");
				String studentName = rs.getString("student_name");
				Student student = new Student(studentId1, studentName);

				String subjectId = rs.getString("subject_id");
				String subjectName = rs.getString("subject_name");
				String semester = rs.getString("semester");
				String numberOfCredits = rs.getString("number_of_credits");
				Subject subject = new Subject(subjectId, subjectName, numberOfCredits, semester);

				String firstMark = rs.getString("first_mark");
				String secondMark = rs.getString("second_mark");
				String status = rs.getString("status");

				Mark mark = new Mark(student, subject, firstMark, secondMark, status);
				list.add(mark);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public boolean updateStatus(Mark m) {
		String sql = "UPDATE mark\r\n" + "SET status=1\r\n" + "WHERE student_id=? AND subject_id=?";
		Connection connection = DBUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, m.getStudent().getId());
			statement.setString(2, m.getSubject().getId());
			boolean rowUpdate = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowUpdate;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean cancelStatus(Mark m) {
		String sql = "UPDATE mark\r\n" + "SET status=?\r\n" + "WHERE student_id=? AND subject_id=?";
		Connection connection = DBUtils.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(2, m.getStudent().getId());
			statement.setString(3, m.getSubject().getId());
			statement.setNull(1, java.sql.Types.NULL);
			boolean rowUpdate = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowUpdate;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateFirstMark(Mark mark) {
		String sql = "UPDATE mark SET first_mark = ?, status = NULL WHERE student_id = ? AND subject_id = ?";
		Connection connection = DBUtils.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setFloat(1, Float.parseFloat(mark.getFirstMark()));
			statement.setString(2, mark.getStudent().getId());
			statement.setString(3, mark.getSubject().getId());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			connection.close();
			return rowInserted;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Mark> firstMarkList() {
		List<Mark> list = new ArrayList<Mark>();
		String sql = "SELECT * FROM mark \r\n" + "JOIN student ON student.id = mark.student_id\r\n"
				+ "JOIN subject ON subject.id = mark.subject_id where mark.first_mark>=5";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String studentId = rs.getString("student_id");
				String studentName = rs.getString("student_name");
				String classId=rs.getString("class_id");
				String firstMark=rs.getString("first_mark");
				Class class1= new Class();
				class1.setId(classId);
				Student student = new Student(studentId, studentName);
				student.setClassroom(class1);

				String semester=rs.getString("semester");
				String subjectName=rs.getString("subject_name");
				Subject subject= new Subject();
				subject.setSemester(semester);
				subject.setName(subjectName);
				Mark mark = new Mark();
				mark.setStudent(student);
				mark.setSubject(subject);
				mark.setFirstMark(firstMark);
				list.add(mark);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	@Override
	public List<Mark> secondMarkList() {
		List<Mark> list = new ArrayList<Mark>();
		String sql = "SELECT * FROM mark \r\n" + "JOIN student ON student.id = mark.student_id\r\n"
				+ "JOIN subject ON subject.id = mark.subject_id where mark.second_mark>=5";
		Connection connection = DBUtils.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String studentId = rs.getString("student_id");
				String studentName = rs.getString("student_name");
				String classId=rs.getString("class_id");
				String secondMark=rs.getString("second_mark");
				Class class1= new Class();
				class1.setId(classId);
				Student student = new Student(studentId, studentName);
				student.setClassroom(class1);

				String semester=rs.getString("semester");
				String subjectName=rs.getString("subject_name");
				Subject subject= new Subject();
				subject.setSemester(semester);
				subject.setName(subjectName);
				Mark mark = new Mark();
				mark.setStudent(student);
				mark.setSubject(subject);
				mark.setSecondMark(secondMark);
				list.add(mark);
			}
			rs.close();
			ps.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
	}

	
}
