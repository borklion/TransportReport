package ru.borklion.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import ru.borklion.model.EmployeeModel;
import ru.borklion.model.TransportReport;
import ru.borklion.utils.TransportReportUtil;
import ru.borklion.view.TransportReportEditor;
import ru.borklion.view.dialogs.Dialogs;

public class TransportReportController {
	private EmployeeModel employees;
	private TransportReport transportReportModel;
	private Shell shell;
	private TicketsStackController ticketsStackController;
	private TransportReportEditor window;

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
			employees = new EmployeeModel();
			window = new TransportReportEditor(shell, this);
			window.setBlockOnOpen(true);
			Realm.runWithDefault(DisplayRealm.getRealm(Display.getCurrent()), new Runnable() {
				@Override
				public void run() {
					window.open();
				}
			});
			Display.getCurrent().dispose();
		} catch (Exception e) {
			Dialogs.showError(shell, "Error", String.format("Error: '%s'", e.getMessage()));
			throw e;
		}
	}

	public EmployeeModel getEmployeeModel() {
		return employees;
	}

	public void CreateReport(int mounth, int year) {
		transportReportModel = new TransportReport(employees.getSelectedEmployee(), mounth, year);
		window.setTripsModel(transportReportModel);
		// window.setTicketsStackModel(ticketsStackModel);
		window.enabledViewers();
		window.setStatus(employees.toString() + "; Дата отчета " + mounth + " " + year);
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
				Dialogs.showError(shell, "Error1", String.format("Error: '%s'", e1.getMessage()));
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
		return path;
	}


	public SelectionAdapter AddClickTripsImportButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ImportXMLFile();
			}
		};
	}
}
