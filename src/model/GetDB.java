package model;

public class GetDB {

	@Override
	public String toString() {
	    return "name=" + this.getName() + ", belong=" + this.getBelong()+ ", status=" + this.getStatus()+ ", comment=" + this.getComment();
	}


	private String name;
	private String belong;
	private String status;
	private String comment;

	public GetDB() {}

	public GetDB(String name, String belong, String status, String comment) {

		this.name = name;
		this.belong = belong;
		this.status = status;
		this.comment = comment;
	}

	public String getName() {return name;}
	public String getBelong() {return belong;}
	public String getStatus() {return status;}
	public String getComment() {return comment;}



}