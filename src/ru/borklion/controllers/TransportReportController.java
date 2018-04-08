package ru.borklion.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.widgets.Composite;

import ru.borklion.model.Employee;
import ru.borklion.model.TransportReport;
import ru.borklion.view.MainWindow;
import ru.borklion.view.RegistrationComposite;
import ru.borklion.view.SelectEmployeeComposite;
import ru.borklion.view.dialogs.Dialogs;

public class TransportReportController {
	private Employee employee;
	private TransportReport transportReport;
	
    public static void main(String[] args) {
        try {
            new TransportReportController();
        } catch (Throwable e) {
            Dialogs.showError(null, "Fatal error", String.format("The necessary libraries could not be loaded: '%s'", e.getMessage()));
            throw e;
        }
    }
    
    public TransportReportController() {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
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
	public void SaveEmployee(String strFIO, String strDepartment, String strBoss, String strAccountant) {
		employee.setFio(strFIO);
		employee.setDepartment(strDepartment);
		employee.setBoss(strBoss);
		employee.setAccountant(strAccountant);
	}
	public void CreateReport(int mounth, int year) {
		this.transportReport = new TransportReport(employee,mounth,year);
	}
	public void addTrip(String[] arg) {
		Date dateTrip;
		try {
			dateTrip = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(arg[3]);
		} catch (ParseException e) {
			dateTrip = null;
		}
		this.transportReport.addTrip(arg[0],arg[2],dateTrip);
	}
}
