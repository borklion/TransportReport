package ru.borklion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

import ru.borklion.gui.RegistrationComposite;
import ru.borklion.gui.SelectEmployeeComposite;

public class TransportReportController {
	private static Employee employee = new Employee();
	private TransportReport transportReport;
	
	public static void Logon(Composite composite) {
		if(true) {
		//выбор сотрудника
			//select из базы с выводом в список для выбора
			//если пусто или нажата кнопка регистрации -- форма регистрации
			SelectEmployeeComposite selectEmployeeComposite = new SelectEmployeeComposite(composite, SWT.None);
			ViewCompositeStackLayout(composite, selectEmployeeComposite);
		} else {
			RegistrationComposite registrationComposite = new RegistrationComposite(composite, SWT.NONE);
			ViewCompositeStackLayout(composite, registrationComposite);
		}
		//создание объекта employee
		//замена кнопки Вход на Выход
		//выбор даты отчета
		//создание объекта TransportReport
	}
	public static <T extends Composite> void ViewCompositeStackLayout(Composite composite, T customComposite) {
		StackLayout layout = (StackLayout) composite.getLayout();
		layout.topControl = customComposite;
		composite.layout();

	}
	public static void SaveEmployee(String strFIO, String strDepartment, String strBoss, String strAccountant) {
		employee.setFio(strFIO);
		employee.setDepartment(strDepartment);
		employee.setBoss(strBoss);
		employee.setAccountant(strAccountant);
	}
	public static void CreateReport(int mounth, int year) {
		this.transportReport = new TransportReport(employee,mounth,year);
	}
	public static void addTrip(String[] arg) {
		Date dateTrip;
		try {
			dateTrip = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(arg[3]);
		} catch (ParseException e) {
			dateTrip = null;
		}
		this.transportReport.addTrip(arg[0],arg[2],dateTrip);
	}
}
