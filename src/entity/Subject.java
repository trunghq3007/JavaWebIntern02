package entity;

public class Subject {
	private String id;
	private String name;
	private String numberOfCredits;
	private String semester;

	public Subject() {
		super();
	}

	public Subject(String semester) {
		super();
		this.semester = semester;
	}

	public Subject(String id, String name, String semester) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
	}

	public Subject(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Subject(String id, String name, String numberOfCredits, String semester) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfCredits = numberOfCredits;
		this.semester = semester;

	}


	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
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

	public String getNumberOfCredits() {
		return numberOfCredits;
	}

	public void setNumberOfCredits(String numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", numberOfCredits=" + numberOfCredits + ", semester="
				+ semester + "]";
	}

}
