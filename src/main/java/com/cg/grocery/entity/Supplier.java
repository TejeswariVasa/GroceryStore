package com.cg.grocery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="suppliers")
public class Supplier {
	
	@Id
	@GeneratedValue
	private int sid;
	private String sname;
	private String location;
	private String company;
	public Supplier(int sid, String sname, String location, String company) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.location = location;
		this.company = company;
	}
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Supplier [sid=" + sid + ", sname=" + sname + ", location=" + location + ", company=" + company + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
