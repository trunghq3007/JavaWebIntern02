package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.IAccount;
import entity.Account;
import entity.Student;
import utils.DBUtils;

public class AccountDAOImpl implements IAccount {
	private Connection conn;
	
    public ArrayList<Account> getFullAccount(){
        conn = DBUtils.getConnection();
        String sql = "SELECT * FROM account";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Account> list = new ArrayList<>();
            Account a;
            while(rs.next()){
                a = new Account();
                a.setUsername(rs.getString("username"));
                a.setStudent(new Student(rs.getString("student_id")));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getString("role"));
                list.add(a);
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    public Account getAccountByID(String username){
        conn = DBUtils.getConnection();
        String sql = "SELECT * FROM account WHERE username = '"+username+"' ";
        try {
            PreparedStatement ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            Account a = new Account();
            if(rs.next()){
                a.setUsername(rs.getString("username"));
                a.setStudent(new Student(rs.getString("student_id")));
                a.setPassword(rs.getString("password"));
                a.setRole(rs.getString("role"));
            }
            return a;
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean updateAccount(Account a){
        conn = DBUtils.getConnection();
        String sql= "update account set password=?, role=? where username=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);            
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getRole());
            ps.setString(3, a.getUsername());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean CheckUsername(String username) {
        conn = DBUtils.getConnection();
        try {

            String sql = "Select * From account Where username=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            boolean result = rs.next();
            rs.close();
            ps.close();
            if (result==true) {
                return true; //đã tồn tại username
            }
        } catch (Exception e) {
        }
        return false; //chưa tồn tại username
    }
    
    public String CheckPassword(String username, String password) {
        conn = DBUtils.getConnection();
        try {
            String sql = "Select role From account Where username='"+ username+"' and password='"+ password+"' ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String roll = "";
            if (rs.next()){
                roll = rs.getString("role");
            }
            return roll;
        } catch (Exception e) {
        }
        return "";
    }
    
    public String getRoleOfUsername(String username) {
        conn = DBUtils.getConnection();
        try {
            String sql = "Select role From account Where username='"+ username+"' ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            String role = "";
            if (rs.next()){
                role = rs.getString("role");
            }
            return role;
        } catch (Exception e) {
        }
        return "";
    }
    
    public boolean InsertAccountStudent(Account acc, Student st) {
    	String id = null;
    	String email = st.getEmail();
        conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
        	String sql = "select id from student where email = '"+email+"'";
        	ps = conn.prepareStatement(sql);
        	ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
        	
            sql = "INSERT INTO account(username,student_id,password,role) VALUES (?,?,?,?)";   
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, id);
            ps.setString(3, acc.getPassword());
            ps.setString(4, "student");
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean InsertAccountAdmin(Account acc) {
        conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO account(username,password,role) VALUES (?,?,?)";   
            ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            ps.setString(3, acc.getRole());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updatePassword(Account a){
        conn = DBUtils.getConnection();
        try {
        	String sql= "update account set password=? where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getPassword());
            ps.setString(2, a.getUsername());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteAccount(String username){
        conn = DBUtils.getConnection();    
        String sql= "DELETE FROM account WHERE username= '"+username+"' ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
             e.printStackTrace();
        }
        return false;
    }
    
    public static void main(String[] args) {
		AccountDAOImpl dao = new AccountDAOImpl();
		System.out.println(dao.getRoleOfUsername("admin01"));
	}
}
