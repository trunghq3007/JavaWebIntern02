package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ISubjectDAO;
import entity.Subject;
import utils.DBUtils;

public class SubjectDAOImpl implements ISubjectDAO {

	@Override
	public List<Subject> findAll() {
			List<Subject> list = new ArrayList<Subject>();
			String sql = "SELECT * FROM subject";
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = null;
			try {
				ps = connection.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("subject_name");
					String numberOfCredits = rs.getString("number_of_credits");

					Subject Subject = new Subject(id, name, numberOfCredits);
					list.add(Subject);
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
	public boolean insert(Subject newSubject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String subjectId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Subject updatesubjectId) {
		// TODO Auto-generated method stub
		return false;
	}

}
