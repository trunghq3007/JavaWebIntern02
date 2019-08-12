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
	private Connection conn;
	private ResultSet result;
	@Override
	public List<Subject> findAll() {
			List<Subject> list = new ArrayList<Subject>();
			String sql = "SELECT * FROM subject";
			Connection connection = DBUtils.getConnection();
			PreparedStatement ps = null;
			try {
				ps = connection.prepareStatement(sql);
				result=ps.executeQuery();
				while (result.next()) {
					String id = result.getString("id");
					String name = result.getString("subject_name");
					String numberOfCredits = result.getString("number_of_credits");
					String semester=result.getString("semester");
					Subject Subject = new Subject(id, name, numberOfCredits,semester);
					list.add(Subject);
				}
				
				result.close();
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return list;
	}

	@Override
	public boolean insert(Subject subject) {
		conn=DBUtils.getConnection();
		String sql =" insert into subject values (?,?,?,?)";
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setString(1, subject.getId());
			ppst.setString(2, subject.getName());
			ppst.setInt(3,Integer.parseInt(subject.getNumberOfCredits()));
			ppst.setInt(4,Integer.parseInt(subject.getSemester()));
			boolean rowInsert=ppst.executeUpdate()>0;
			
			ppst.close();
			conn.close();
			return rowInsert; 
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean delete(String id) {
		conn=DBUtils.getConnection();
		String sql =" delete from subject where id=?";
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setString(1, id);
			boolean row=ppst.executeUpdate()>0;
			ppst.close();
			conn.close();
			return row;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public boolean update(Subject subject) {
		conn=DBUtils.getConnection();
		String sql =" update subject set subject_name=? , number_of_credits=? , semester=? where id=?";
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setNString(1, subject.getName());
			ppst.setInt(2, Integer.parseInt(subject.getNumberOfCredits()));
			ppst.setInt(3,Integer.parseInt(subject.getSemester()));
			ppst.setString(4, subject.getId());
			boolean row=ppst.executeUpdate()>0;
			ppst.close();
			conn.close();
			return row;
		} catch (SQLException e) {
			return false;
		}
	}

	@Override
	public Subject getById(String id) {
		conn=DBUtils.getConnection();
		String sql =" select * from subject where id=? ";
		Subject subject= null;
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setString(1, id);
			result=ppst.executeQuery();
			while(result.next()) {
				subject = new Subject();
				subject.setId(result.getString("id"));
				subject.setName(result.getString("subject_name"));
				subject.setNumberOfCredits(String.valueOf(result.getInt("number_of_credits")));
				subject.setSemester(String.valueOf(result.getInt("semester")));
			}
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public Subject getByName(String name) {
		conn=DBUtils.getConnection();
		String sql =" select * from subject where subject_name=? ";
		Subject subject=null;
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setString(1, name);
			result=ppst.executeQuery();
			while(result.next()) {
				subject= new Subject();
				subject.setId(result.getString("id"));
				subject.setName(result.getString("subject_name"));
				subject.setNumberOfCredits(String.valueOf(result.getInt("number_of_credits")));
				subject.setSemester(String.valueOf(result.getInt("semester")));
			}
			
			
			ppst.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public List<Subject> searchGanDung(String search) {
		conn=DBUtils.getConnection();
		String sql =" select * from subject where id like ? or subject_name like ? ";
		List<Subject> list= new ArrayList<Subject>();
		try {
			PreparedStatement ppst= conn.prepareStatement(sql);
			ppst.setString(1,"%"+search+"%");
			ppst.setString(2, "%"+search+"%");
			result= ppst.executeQuery();
			while(result.next()) {
				Subject subject= new Subject();
				subject.setId(result.getString("id"));
				subject.setName(result.getString("subject_name"));
				subject.setNumberOfCredits(String.valueOf(result.getInt("number_of_credits")));
				subject.setSemester(String.valueOf(result.getInt("semester")));
				list.add(subject);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
