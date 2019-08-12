package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.IStudentDAO;
import entity.Account;
import entity.Class;
import entity.Student;
import utils.DBUtils;
//import utils.SQLConnectionJDBC;

public class StudentDAOImpl implements IStudentDAO {
	
	public boolean CheckEmail(String email) {
        Connection conn = DBUtils.getConnection();
        try {

            String sql = "Select * From student Where email=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();
            rs.close();
            ps.close();
            if (result==true) {
                return true; //đã tồn tại email
            }
        } catch (Exception e) {
        }
        return false; //chưa tồn tại email
    }
    
    public boolean CheckEmailRegisred(String email) {
        Connection conn = DBUtils.getConnection();
        try {

            String sql = "Select * From account Where student_id = ( select id from student where email = ? )";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();
            rs.close();
            ps.close();
            if (result==true) {
                return true; //email đã kích hoạt tài khoản
            }
        } catch (Exception e) {
        }
        return false; //email chưa kích hoạt tài khoản
    }
    
    public String getUsernameOfEmail(String email) {
        Connection conn = DBUtils.getConnection();
        try {
            String sql = "Select username From account Where student_id = (Select id From student Where email = '"+ email +"')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String username = "";
            if (rs.next()){
            	username = rs.getString("username");
            }
            return username;
        } catch (Exception e) {
        }
        return "";
    }
    
    public Student getStudentByUsername(String username) {
    	Connection conn = DBUtils.getConnection();
        String sql = "SELECT * FROM student WHERE id = (SELECT student_id FROM account WHERE username = '"+ username +"') ";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            Student a = new Student();
            if(rs.next()){
                a.setId(rs.getString("id"));
                //có thể thêm dữ liệu cần lấy ở đây
            }
            return a;
        } catch (Exception e) {
        }
        return null;
	}

	@Override
	public List<Student> queryStudent() {
//		List<Student> list = new ArrayList<Student>();
//		String sql = "SELECT * \r\n" + 
//					"FROM student\r\n" + 
//					"JOIN class		ON class.id		 = student.class_id\r\n";
//		Connection connection = DBUtils.getConnection();
//		PreparedStatement ps = null;
//		try {
//			ps = connection.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				String id = rs.getString("id");
//				String name = rs.getString("student_name");
//				String gender = rs.getString("gender");
//				String email = rs.getString("email");
//				String birthDate = rs.getString("birth_date");
//				String birthPlace = rs.getString("birth_place");
//				
//				String classId = rs.getString("class_id");
//				String className = rs.getString("class_name");
//				String course = rs.getString("course");
//				String trainingTpye = rs.getString("training_type");
//				String department = rs.getString("department");
//
//				Class class1 = new Class(classId, className, course, trainingTpye, department);
//				Student student = new Student(id, name, gender, email, birthDate, birthPlace, class1);
//				list.add(student);
//			}
//			
//			rs.close();
//			ps.close();
//			connection.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//			return null;
//		}
//		return list;
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM student";
		Statement statement;
		List<Student> list = new ArrayList<Student>();
		try {
			statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery(sql);

			// Lay ket qua
			while (resultSet.next()) {
				String idStudent = resultSet.getString("id");
				String name = resultSet.getString("student_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String birth_date = resultSet.getString("birth_date");
				String birth_place = resultSet.getString("birth_place");
				String class_id = resultSet.getString("class_id");

				Class class1 = new Class(class_id);
				Student student = new Student(idStudent, name, gender, email, birth_date, birth_place, class1);

				list.add(student);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public boolean InsertQuery(Student student) {
		Connection connection = null;
		String sql = "INSERT INTO student(id, student_name, gender, email, birth_date, birth_place, class_id) VALUES(?, ?, ?, ?, ?, ? , ?)";
		int n = 0;
		try {
			connection = DBUtils.getConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, student.getId());
			statement.setString(2, student.getName());
			statement.setString(3, student.getGender());
			statement.setString(4, student.getEmail());
			statement.setString(5, student.getBirthDate());
			statement.setString(6, student.getBirthPlace());
			statement.setString(7, student.getClassroom().getId());
			n = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (n == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean deleteQuery(String maSV) {
		Connection connection = DBUtils.getConnection();

		String sql = "DELETE FROM student WHERE id = ?";

		int temp = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, maSV);

			// Tra lai so luong ban ghi duoc update
			temp = statement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (temp == 0) {
			return false;
		} else
			return true;
	}

	@Override
	public boolean editQuery(Student student) {
		Connection connection = DBUtils.getConnection();
		String sql = "UPDATE student SET  student_name = ?, gender = ?, email = ?, birth_date = ?, birth_place = ?  WHERE id = ?";
		int n = 0;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, student.getName());
			preparedStatement.setString(2, student.getGender());
			preparedStatement.setString(3, student.getEmail());
			preparedStatement.setString(4, student.getBirthDate());
			preparedStatement.setString(5, student.getBirthPlace());
//			preparedStatement.setString(6, student.getAccount().getUsername());
//			preparedStatement.setString(6, student.getClassroom().getId());
			preparedStatement.setString(6, student.getId());

			n = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (n == 0) {
			return false;

		} else
			return true;
	}

	@Override
	// Ham SearchStudent by ID or Name
	public List<Student> searchStudentbyName(String name) {
		List<Student> list = new ArrayList<Student>();
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM student WHERE student_name LIKE ?  ";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + name + "%");

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String idStudent = resultSet.getString("id");
				String name1 = resultSet.getString("student_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String birthDate = resultSet.getString("birth_date");
				String birthPlace = resultSet.getString("birth_place");
//				String username = resultSet.getString("username");
				String classroom = resultSet.getString("class_id");

				Class classID = new Class(classroom);
//				Account account = new Account(username);
				Student student2 = new Student(idStudent, name1, gender, email, birthDate, birthPlace, classID);

				list.add(student2);

			}

			return list;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	// Ham kiem tra class_id phai ton tai thi moi them duoc
	public boolean checkClassID(String classID) {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT id FROM class WHERE id = ? ";
		String id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, classID);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getString("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (id == null) {
			return false;
		} else
			return true;

	}

	@Override
	// Ham check Ma Sinh Vien
	public boolean checkIDStudent(String studentID) {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT id FROM student WHERE id = ? ";
		String id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, studentID);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getString("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (id == null) {
			return true;
		} else
			return false;

	}

	// Ham check email
	public boolean checkEmail(String email) {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT email FROM student WHERE email = ? ";
		String id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				id = resultSet.getString("id");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (id == null) { //không tồn tại
			return true;
		} else
			return false;

	}

	@Override
	public Student searchStudentbyID(String studentId) {
		Connection connection = DBUtils.getConnection();
		String sql = "SELECT * FROM student WHERE id = ?";

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, studentId);
			Student student2 = null;
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String idStudent = resultSet.getString("id");
				String name = resultSet.getString("student_name");
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String birthDate = resultSet.getString("birth_date");
				String birthPlace = resultSet.getString("birth_place");
//				String username = resultSet.getString("username");
				String classroom = resultSet.getString("class_id");

				Class classID = new Class(classroom);
//				Account account = new Account(username);
				student2 = new Student(idStudent, name, gender, email, birthDate, birthPlace, classID);

			}

			return student2;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
