package ru.borklion.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.borklion.model.EmployeeModel;
import ru.borklion.model.TicketsStack;
import ru.borklion.model.TransportReportModel;
import ru.borklion.utils.TransportReportUtil;
import ru.borklion.view.MainWindow;
import ru.borklion.view.RegistrationComposite;
import ru.borklion.view.SelectEmployeeComposite;
import ru.borklion.view.SelectNewDateReportComposite;
import ru.borklion.view.TripsAndTicketsComposite;
import ru.borklion.view.dialogs.AddTicketDialog;
import ru.borklion.view.dialogs.Dialogs;

public class TransportReportController {
	private EmployeeModel employees;
	private TransportReportModel transportReport;
	private Shell shell;
	
	private TripsAndTicketsComposite tripsAndTicketsComposite;
	
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
			Display display = Display.getDefault();
			shell = new Shell();
			MainWindow window = new MainWindow(shell);
			window.open();
			window.getButtonLogon().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Logon(window.getComposite());
				}
			});
			shell.open();
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public void Logon(Composite composite) {
		employees = new EmployeeModel();
		String[] items = employees.getAll();
		if(items.length > 0) {
			SelectEmployeeComposite selectEmployeeComposite = new SelectEmployeeComposite(composite, SWT.NONE);
			selectEmployeeComposite.getCombo().setItems(items);
			ViewCompositeStackLayout(composite, selectEmployeeComposite);
			selectEmployeeComposite.getButtonLogon().addSelectionListener(new SelectionAdapter() {
				
			});
			selectEmployeeComposite.getButtonRegistration().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					Registration(composite);
				}
			});
		} else {
			Registration(composite);
		}
		composite.setVisible(true);
	}
	
	public void Registration(Composite composite) {
		RegistrationComposite registrationComposite = new RegistrationComposite(composite, SWT.NONE);
		ViewCompositeStackLayout(composite, registrationComposite);
		registrationComposite.getButtonSave().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] field = registrationComposite.getTextField();
				employees.addEmployee(field[0], field[1], field[2], field[3]);
				SelectNewDateReportComposite selectNewDateReportComposite = new SelectNewDateReportComposite(composite, SWT.NONE);
				ViewCompositeStackLayout(composite, selectNewDateReportComposite);
				selectNewDateReportComposite.getButton().addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					CreateReport(selectNewDateReportComposite.getDateReport().getMonth(),selectNewDateReportComposite.getDateReport().getYear());
					tripsAndTicketsComposite = new TripsAndTicketsComposite(composite, SWT.NONE);
					ViewCompositeStackLayout(composite, tripsAndTicketsComposite);
					tripsAndTicketsComposite.getTripsComposite().getNewButton().addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							ImportXMLFile();
						}
					});
					tripsAndTicketsComposite.getTripsComposite().getTripsViewer().setInput(transportReport);
					tripsAndTicketsComposite.getTicketsStackComposite().getAddButton().addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							AddTicketDialog dialog = new AddTicketDialog(shell, SWT.DIALOG_TRIM);
							dialog.open();
						}
					});
					tripsAndTicketsComposite.getTicketsStackComposite().getDeleteButton().addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {
							TicketsStack.INSTANCE.DeleteTicket(tripsAndTicketsComposite.getTicketsStackComposite().getListTickets().getSelectionIndex());
						}
					});
					TicketsStack.INSTANCE.addListener(new Observer() {
						@Override
						public void update(Observable o, Object arg) {
							tripsAndTicketsComposite.getTicketsStackComposite().getListTickets().setItems((String[])arg);
						}
					});
				}
			});

			}
		});
		
	}
	public <T extends Composite> void ViewCompositeStackLayout(Composite composite, T customComposite) {
		StackLayout layout = (StackLayout) composite.getLayout();
		layout.topControl = customComposite;
		composite.layout();

	}
	public void CreateReport(int mounth, int year) {
		transportReport = new TransportReportModel(employees.getSelectedEmployee(),mounth,year);
	}
	
    public void ImportXMLFile() {
		String pathFileXML = SelectFile();
		if(pathFileXML != null) {
			try {
				File fileIn = new File(pathFileXML);
				List<String[]> listTrip = TransportReportUtil.XMLParse(fileIn);
				for(String[] el:listTrip) {
					transportReport.addTrip(el);
				}
				tripsAndTicketsComposite.getTripsComposite().getTripsViewer().refresh();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
    }
    public String SelectFile() {
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		String[] filterNames = new String[] {"XML files", "All Files (*)"};
		String[] filterExtensions = new String[] {"*.xml", "*"};
		dialog.setFilterNames(filterNames);
		dialog.setFilterExtensions(filterExtensions);
		String path = dialog.open();
//		System.out.println(path);
		return path;
    }
}
