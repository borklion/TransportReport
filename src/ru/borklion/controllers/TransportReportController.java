package ru.borklion.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.borklion.model.EmployeeModel;
import ru.borklion.model.TicketsStackModel;
import ru.borklion.model.TransportReportModel;
import ru.borklion.utils.TransportReportUtil;
import ru.borklion.view.TransportReportEditor;
import ru.borklion.view.dialogs.AddTicketDialog;
import ru.borklion.view.dialogs.Dialogs;

public class TransportReportController {
	private EmployeeModel employees;
	private TransportReportModel transportReportModel;
	private Shell shell;
	private TransportReportEditor window;
	private TicketsStackModel ticketsStackModel;
	private AddTicketDialog dialog;

	public static void main(String[] args) {
		try {
			new TransportReportController();
		} catch (Throwable e) {
			Dialogs.showError(null, "Fatal error",
					String.format("The necessary libraries could not be loaded: '%s'", e.getMessage()));
			throw e;
		}
	}

	public TransportReportController() {
		try {
			shell = new Shell();
			window = new TransportReportEditor(shell,this);
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public void Logon(Composite composite) {
//		employees = new EmployeeModel();
//		String[] items = employees.getAll();
//		if (items.length > 0) {
//			SelectEmployeeComposite selectEmployeeComposite = new SelectEmployeeComposite(composite, SWT.NONE);
//			selectEmployeeComposite.getCombo().setItems(items);
//			ViewCompositeStackLayout(composite, selectEmployeeComposite);
//			selectEmployeeComposite.getButtonLogon().addSelectionListener(new SelectionAdapter() {
//
//			});
//			selectEmployeeComposite.getButtonRegistration().addSelectionListener(new SelectionAdapter() {
//				@Override
//				public void widgetSelected(SelectionEvent e) {
//					Registration(composite);
//				}
//			});
//		} else {
//			Registration(composite);
//		}
//		composite.setVisible(true);
//	}
//
//	public void Registration(Composite composite) {
//		RegistrationComposite registrationComposite = new RegistrationComposite(composite, SWT.NONE);
//		ViewCompositeStackLayout(composite, registrationComposite);
//		registrationComposite.getButtonSave().addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				String[] field = registrationComposite.getTextField();
//				employees.addEmployee(field[0], field[1], field[2], field[3]);
//				SelectNewDateReportComposite selectNewDateReportComposite = new SelectNewDateReportComposite(composite,
//						SWT.NONE);
//				ViewCompositeStackLayout(composite, selectNewDateReportComposite);
//				selectNewDateReportComposite.getButton().addSelectionListener(new SelectionAdapter() {
//					@Override
//					public void widgetSelected(SelectionEvent e) {
//						CreateReport(selectNewDateReportComposite.getDateReport().getMonth(),
//								selectNewDateReportComposite.getDateReport().getYear());
//						tripsAndTicketsComposite = new TripsAndTicketsComposite(composite, SWT.NONE);
//						tripsAndTicketsComposite.getTripsComposite().getTripsViewer().setInput(transportReport);
//					}
//				});
//
//			}
//		});
//
//	}

//	public <T extends Composite> void ViewCompositeStackLayout(Composite composite, T customComposite) {
//		StackLayout layout = (StackLayout) composite.getLayout();
//		layout.topControl = customComposite;
//		composite.layout();
//
//	}

	public void CreateReport(int mounth, int year) {
		transportReportModel = new TransportReportModel(employees.getSelectedEmployee(), mounth, year);
		ticketsStackModel = new TicketsStackModel();
		window.setTripsModel(transportReportModel);
		window.setTicketsStackModel(ticketsStackModel);
	}

	public void ImportXMLFile() {
		String pathFileXML = SelectFile();
		if (pathFileXML != null) {
			try {
				File fileIn = new File(pathFileXML);
				List<String[]> listTrip = TransportReportUtil.XMLParse(fileIn);
				for (String[] el : listTrip) {
					transportReportModel.addTrip(el);
				}
				window.TripsRefresh();

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	public String SelectFile() {
		FileDialog dialog = new FileDialog(shell, SWT.OPEN);
		String[] filterNames = new String[] { "XML files", "All Files (*)" };
		String[] filterExtensions = new String[] { "*.xml", "*" };
		dialog.setFilterNames(filterNames);
		dialog.setFilterExtensions(filterExtensions);
		String path = dialog.open();
		// System.out.println(path);
		return path;
	}
	public SelectionAdapter AddClickTicketsStackAddButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dialog = new AddTicketDialog(shell, SWT.DIALOG_TRIM);
				dialog.open();
			}
		};
	}
	public SelectionAdapter AddClickTicketsStackDeleteButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ticketsStackModel.DeleteTicket(window.getTicketsStackSelectionIndex());
			}
		};
	}
	public SelectionAdapter AddClickTripsImportButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ImportXMLFile();
			}
		};
	}
	public SelectionAdapter AddClickOkButtonDialogAddTicket() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String[] field = dialog.getField();
				if (!TransportReportUtil.isNullOrBlank(field[0]) && !TransportReportUtil.isNullOrBlank(field[1]) && !TransportReportUtil.isNullOrBlank(field[2])) {
					ticketsStackModel.AddTicket(field);
					dialog.changeResult(Boolean.TRUE);
					dialog.close();
				}

			}
		};
	}
}
