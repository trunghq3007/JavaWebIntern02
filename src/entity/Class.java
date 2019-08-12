package entity;

public class Class {
	private String id;
	private String name;
	private String course;
	private String trainingType;
	private String department;

	public Class() {
		super();
	}
	
	
	public Class(String id) {
		super();
		this.id = id;
	}


	public Class(String id, String name, String course, String trainingType, String department) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.trainingType = trainingType;
		this.department = department;
	}

	public Class(String id, String name) {
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getTrainingType() {
		return trainingType;
	}

	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", course=" + course + ", trainingType=" + trainingType
				+ ", department=" + department + "]";
	}

}
