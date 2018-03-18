package ru.borklion;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

import ru.borklion.gui.RegistrationComposite;
import ru.borklion.gui.SelectEmployeeComposite;

public class TransportReportController {
	static Employee employee = new Employee();
	public static void Logon(Composite composite) {
		if(true) {
		//выбор сотрудника
			//select из базы с выводом в список для выбора
			//если пусто или нажата кнопка регистрации -- форма регистрации
			SelectEmployeeComposite selectEmployeeComposite = new SelectEmployeeComposite(composite, SWT.None);
			StackLayout layout = (StackLayout) composite.getLayout();
			layout.topControl = selectEmployeeComposite;
			composite.layout();
		} else ViewRegistrationForm(composite);
		//создание объекта employee
		//замена кнопки Вход на Выход
		//выбор даты отчета
		//создание объекта TransportReport
	}
	public static void ViewRegistrationForm(Composite composite) {
		RegistrationComposite registrationComposite = new RegistrationComposite(composite, SWT.NONE);
		StackLayout layout = (StackLayout) composite.getLayout();
		layout.topControl = registrationComposite;
		composite.layout();

	}
	public static void SaveEmployee(String strFIO, String strDepartment, String strBoss, String strAccountant) {
		employee.setFio(strFIO);
		employee.setDepartment(strDepartment);
		employee.setBoss(strBoss);
		employee.setAccountant(strAccountant);
	}
	public static void CreateReport(int mounth, int year) {
		TransportReport transportReport = new TransportReport(employee,mounth,year);
	}
}
