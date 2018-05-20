package ru.borklion.view.dialogs;

import org.eclipse.jface.wizard.Wizard;

public class LogonWizard extends Wizard {
	SelectEmployeePage selectEmployeePage;
	SelectDateReportPage selectDateReportPage;
	RegistrationPage registrationPage;
	public LogonWizard() {
		setWindowTitle("Вход");
	}

	@Override
	public void addPages() {
		selectEmployeePage = new SelectEmployeePage();
		addPage(selectEmployeePage);
		registrationPage = new RegistrationPage();
		addPage(registrationPage);
		selectDateReportPage = new SelectDateReportPage();
		addPage(selectDateReportPage);
	}

	@Override
	public boolean performFinish() {
		return true;
	}
	public boolean canFinish()
	{
		// cannot completr the wizard from the first page
		if (this.getContainer().getCurrentPage().equals(selectEmployeePage)) 
			return false;
		// based on the type of transport return the right flag			
//		if (model.usePlane) return planeCompleted;
		return true;
	}
}
