package com.tw.apistackbase;

public class EmployeeBean {
	private int id;
	private String employeeName;
	private int age;
	private String gender;
	private int salary;
	public String belongCompanyId;
	
	public EmployeeBean() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getBelongCompanyId() {
		return belongCompanyId;
	}

	public void setBelongCompanyId(String belongCompanyId) {
		this.belongCompanyId = belongCompanyId;
	}

	public EmployeeBean(int id, String employeeName, int age, String gender, int salary, String belongCompanyId) {
		this.id = id;
		this.employeeName = employeeName;
		this.age = age;
		this.gender = gender;
		this.salary = salary;
		this.belongCompanyId = belongCompanyId;
	}
	
	
}
