package com.khadri.spring.mvc.entity;

//Entity 
public class Student {
	
	// need to add identifier
	
	private String name;
	private String age;
	private String branch;
	private String phone;
	private String address;
	private String parentPhone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParentPhone() {
		return parentPhone;
	}
	public void setParentPhone(String parentPhone) {
		this.parentPhone = parentPhone;
	}
	
	
	
}
