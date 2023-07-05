package com.cg.grocery.dto;

public class CreateDistributorRequest {
	private int did;
	private String dname;
	private String location;
	private String company;
	@Override
	public String toString() {
		return "CreateDistributorRequest [did=" + did + ", dname=" + dname + ", location=" + location + ", company="
				+ company + "]";
	}
	public CreateDistributorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreateDistributorRequest(int did, String dname, String location, String company) {
		super();
		this.did = did;
		this.dname = dname;
		this.location = location;
		this.company = company;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}


}
