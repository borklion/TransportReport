package ru.borklion.view.dialogs;

import org.eclipse.jface.wizard.Wizard;

import ru.borklion.controllers.TransportReportController;

public class LogonWizard extends Wizard {
	SelectEmployeePage selectEmployeePage;
	SelectDateReportPage selectDateReportPage;
	RegistrationPage registrationPage;
	TransportReportController controller;

	public LogonWizard(TransportReportController controller) {
		setWindowTitle("Вход");
		this.controller = controller;
	}

	@Override
	public void addPages() {
		selectEmployeePage = new SelectEmployeePage(controller.getEmployeeModel());
		addPage(selectEmployeePage);
		registrationPage = new RegistrationPage(controller.getEmployeeModel());
		addPage(registrationPage);
		selectDateReportPage = new SelectDateReportPage();
		addPage(selectDateReportPage);
	}

	@Override
	public boolean performFinish() {
		if (registrationPage.isPageComplete()) {
			controller.getEmployeeModel().addEmployee(registrationPage.getFieldText()[0],
					registrationPage.getFieldText()[1], registrationPage.getFieldText()[2],
					registrationPage.getFieldText()[3]);
		}
		if (selectDateReportPage.isPageComplete()) {
			controller.CreateReport(selectDateReportPage.getDateSelected()[0],
					selectDateReportPage.getDateSelected()[1]);
		}
		return true;
	}

	public boolean canFinish() {
		// cannot completr the wizard from the first page
		if (this.getContainer().getCurrentPage().equals(selectDateReportPage))
			return true;
		// based on the type of transport return the right flag
		// if (model.usePlane) return planeCompleted;
		return false;
	}
}
