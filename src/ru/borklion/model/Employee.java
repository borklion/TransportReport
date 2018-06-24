package ru.borklion.model;

public class Employee extends AbstractModel {
	private String fio;
	private String department;
	private String boss;
	private String accountant;
	
	public Employee() {
	}

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
		firePropertyChange("fio", this.fio, fio);
		this.fio = fio;
	}

	public void setDepartment(String department) {
		firePropertyChange("department", this.department, department);
		this.department = department;
	}

	public void setBoss(String boss) {
		firePropertyChange("boss", this.boss, boss);
		this.boss = boss;
	}

	public void setAccountant(String accountant) {
		firePropertyChange("accountant", this.accountant, accountant);
		this.accountant = accountant;
	}

	@Override
	public String toString() {
		return fio + " " + department;
	}
}
