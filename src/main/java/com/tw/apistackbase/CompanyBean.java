package com.tw.apistackbase;

public class CompanyBean {
	private int id;
	private String companyName;
	private int employeeNumber;
	private EmployeeBean employeeBean;
	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	

	public CompanyBean() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public CompanyBean(int id, String companyName,int employeeNumber) {
		this.id = id;
		this.companyName = companyName;
		this.employeeNumber = employeeNumber;
	}

	public CompanyBean(int id, String companyName, int employeeNumber, EmployeeBean employeeBean) {
		this.id = id;
		this.companyName = companyName;
		this.employeeNumber = employeeNumber;
		this.employeeBean = employeeBean;
	}
	
	
}
