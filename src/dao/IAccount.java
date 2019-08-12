package dao;

import java.util.ArrayList;

import entity.Account;
import entity.Student;

public interface IAccount {
	ArrayList<Account> getFullAccount();
	Account getAccountByID(String username);
	boolean updateAccount(Account a);
	boolean CheckUsername(String username);
	String CheckPassword(String username, String password);
	String getRoleOfUsername(String username);
	boolean InsertAccountStudent(Account acc, Student st);
	boolean InsertAccountAdmin(Account acc);
	boolean updatePassword(Account a);
	boolean deleteAccount(String username);
}
