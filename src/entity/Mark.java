package entity;

public class Mark {
	private Student student;
	private Subject subject;
	private String firstMark;
	private String secondMark;
	private String status;

	public Mark() {
		super();
	}

	public Mark(Student student, Subject subject, String firstMark, String secondMark, String status) {
		super();
		this.student = student;
		this.subject = subject;
		this.firstMark = firstMark;
		this.secondMark = secondMark;
		this.status = status;
	}

	public Mark(Student student, Subject subject, String firstMark) {
		super();
		this.student = student;
		this.subject = subject;
		this.firstMark = firstMark;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getFirstMark() {
		return firstMark;
	}

	public void setFirstMark(String firstMark) {
		this.firstMark = firstMark;
	}

	public String getSecondMark() {
		return secondMark;
	}

	public void setSecondMark(String secondMark) {
		this.secondMark = secondMark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Mark [student=" + student + ", subject=" + subject + ", firstMark=" + firstMark + ", secondMark="
				+ secondMark + ", status=" + status + "]";
	}

}
