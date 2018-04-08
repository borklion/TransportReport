package ru.borklion.model;

import java.util.ArrayList;
import java.util.List;

import ru.borklion.dao.Employee;

public class EmployeeModel {
	private List<Employee> employees = new ArrayList<>();
	private int selectedEmployee;
	
	public EmployeeModel() {
		selectedEmployee = 0;
	}
	
	public void addEmployee(String fio, String department, String boss, String accountant) {
		int countEmployees = employees.size();
		this.employees.add(new Employee(fio, department, boss, accountant));
		selectedEmployee = countEmployees;
	}
	
	public Employee getSelectedEmployee() {
		return employees.get(selectedEmployee);
	}
	
	public String[] getAll() {
		return new String[] {};
	}
}
