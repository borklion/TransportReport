package ru.borklion.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

import ru.borklion.model.EmployeeModel;
import ru.borklion.model.TransportReportModel;
import ru.borklion.utils.TransportReportUtil;
import ru.borklion.view.MainWindow;
import ru.borklion.view.RegistrationComposite;
import ru.borklion.view.SelectEmployeeComposite;
import ru.borklion.view.SelectNewDateReportComposite;
import ru.borklion.view.TripsAndTicketsComposite;
import ru.borklion.view.dialogs.Dialogs;

public class TransportReportController {
	private EmployeeModel employee;
	private TransportReportModel transportReport;
	private Shell shell;
	
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
			shell = new Shell();
			MainWindow window = new MainWindow(shell);
			window.getButtonLogon().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Logon(window.getComposite());
			}
		});
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void Logon(Composite composite) {
		if(false) {
		//выбор сотрудника
			//select из базы с выводом в список для выбора
			//если пусто или нажата кнопка регистрации -- форма регистрации
			SelectEmployeeComposite selectEmployeeComposite = new SelectEmployeeComposite(composite, SWT.None);
			ViewCompositeStackLayout(composite, selectEmployeeComposite);
		} else {
			RegistrationComposite registrationComposite = new RegistrationComposite(composite, SWT.NONE);
			ViewCompositeStackLayout(composite, registrationComposite);
			Button buttonSave = registrationComposite.getButtonSave();
			buttonSave.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					String[] field = registrationComposite.getTextField();
					employee = new EmployeeModel(field[0], field[1], field[2], field[3]);
					SelectNewDateReportComposite selectNewDateReportComposite = new SelectNewDateReportComposite(composite, SWT.NONE);
					ViewCompositeStackLayout(composite, selectNewDateReportComposite);
					selectNewDateReportComposite.getButton().addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						CreateReport(selectNewDateReportComposite.getDateReport().getMonth(),selectNewDateReportComposite.getDateReport().getYear());
						TripsAndTicketsComposite tripsAndTicketsComposite = new TripsAndTicketsComposite(composite, SWT.NONE);
						ViewCompositeStackLayout(composite, tripsAndTicketsComposite);
					}
				});

				}
			});
		}
		composite.setVisible(true);
		//создание объекта employee
		//замена кнопки Вход на Выход
		//выбор даты отчета
		//создание объекта TransportReport
	}
	public <T extends Composite> void ViewCompositeStackLayout(Composite composite, T customComposite) {
		StackLayout layout = (StackLayout) composite.getLayout();
		layout.topControl = customComposite;
		composite.layout();

	}
	public void CreateReport(int mounth, int year) {
		this.transportReport = new TransportReportModel(employee.getEmployee(),mounth,year);
	}
	
    public void ImportXMLFile(Composite parent) {
		String pathFileXML = TransportReportUtil.SelectFile(parent.getShell());
		if(pathFileXML != null) {
			try {
				File fileIn = new File(pathFileXML);
				List<String[]> listTrip = TransportReportUtil.XMLParse(fileIn);
				for(String[] el:listTrip) {
					transportReport.addTrip(el);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }

}
