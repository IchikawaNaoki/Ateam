package model;

public class GetDB {

	@Override
	public String toString() {
	    return "id=" + this.getId() + ", name=" + this.getName() + ", department=" + this.getDepartment();
	}

	private int id;
	private String name;
	private String department;

	public GetDB() {}

	public GetDB(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public int getId() {return id;}
	public String getName() {return name;}
	public String getDepartment() {return department;}


}