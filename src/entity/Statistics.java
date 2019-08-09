package entity;

public class Statistics {

	private double mark_avarage;
	private String scholarship;
	private Student student;
	private Class classroom;
	private Subject subject;

	public double getMark_avarage() {
		return mark_avarage;
	}

	public void setMark_avarage(double mark_avarage) {
		this.mark_avarage = mark_avarage;
	}

	public String getScholarship() {
		return scholarship;
	}

	public void setScholarship(String scholarship) {
		this.scholarship = scholarship;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Class getClassroom() {
		return classroom;
	}

	public void setClassroom(Class classroom) {
		this.classroom = classroom;
	}


	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Statistics() {
		super();
	}

	public Statistics(double mark_avarage, String scholarship, Student student, Class classroom, Subject subject) {
		super();
		this.mark_avarage = mark_avarage;
		this.scholarship = scholarship;
		this.student = student;
		this.classroom = classroom;
		this.subject = subject;
	}

	public Statistics(double mark_avarage, Student student, Class classroom, Subject subject) {
		super();
		this.mark_avarage = mark_avarage;
		this.student = student;
		this.classroom = classroom;
		this.subject = subject;
	}
	
}
