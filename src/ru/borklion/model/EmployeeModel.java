package ru.borklion.model;

import ru.borklion.dao.Employee;

public class EmployeeModel {
	private Employee employee;
	
	public EmployeeModel(String fio, String department, String boss, String accountant) {
		this.employee = new Employee(fio, department, boss, accountant);
	}
	
	public Employee getEmployee() {
		return this.employee;
	}
}
