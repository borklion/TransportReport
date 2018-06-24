package ru.borklion.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends AbstractModel {
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
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	@Override
	public String toString() {
		return getSelectedEmployee().getFio() + "; " + getSelectedEmployee().getDepartment();
	}
}
