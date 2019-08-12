package entity;

public class Account {
	private String username;
	private Student student;
	private String password;
	private String role;

	public Account() {
		super();
	}

	public Account(String username, Student student, String password, String role) {
		super();
		this.username = username;
		this.student = student;
		this.password = password;
		this.role = role;
	}

	
	public Account(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Account [username=" + username + ", studentId=" + student + ", password=" + password + ", role="
				+ role + "]";
	}

}
