package entity;

public class Student {
	private String id;
	private String name;
	private String gender;
	private String email;
	private String birthDate;
	private String birthPlace;
	private Class classroom;

	public Student() {
		super();
	}

	public Student(String id) {
		super();
		this.id = id;
	}

	public Student(String id, String name, String gender, String email, String birthDate, String birthPlace,
			Class classroom) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.birthDate = birthDate;
		this.birthPlace = birthPlace;
		this.classroom = classroom;
	}

	public Student(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}

	public Class getClassroom() {
		return classroom;
	}

	public void setClassroom(Class classroom) {
		this.classroom = classroom;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", birthDate="
				+ birthDate + ", birthPlace=" + birthPlace + ", classroom=" + classroom + "]";
	}

}
