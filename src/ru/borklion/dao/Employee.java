package ru.borklion.dao;

public class Employee {
	private String fio;
	private String department;
	private String boss;
	private String accountant;
	
	public Employee(String fio, String department, String boss, String accountant) {
		this.fio = fio;
		this.department = department;
		this.boss = boss;
		this.accountant = accountant;
	}
	
	public String getFio() {
		return fio;
	}
	public String getDepartment() {
		return department;
	}
	public String getBoss() {
		return boss;
	}
	public String getAccountant() {
		return accountant;
	}
	public void setFio(String fio) {
		this.fio = fio;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setBoss(String boss) {
		this.boss = boss;
	}
	public void setAccountant(String accountant) {
		this.accountant = accountant;
	}
}
