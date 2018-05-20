package ru.borklion.view.dialogs;

import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class SelectEmployeePage extends WizardPage implements Listener {
	private Combo combo;
	private Button buttonLogon;
	private Button buttonRegistration;
	/**
	 * Create the wizard.
	 */
	public SelectEmployeePage() {
		super("wizardPage");
		setTitle("ВХОД");
		setDescription("Выберите себя или зарегистрируйтесь");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		combo = new Combo(container, SWT.NONE);
		combo.setBounds(134, 130, 300, 28);
		
		buttonLogon = new Button(container, SWT.RADIO);
		buttonLogon.setBounds(134, 158, 94, 28);
		buttonLogon.setText("Выбор из списка");
		buttonLogon.setSelection(true);
		
		buttonRegistration = new Button(container, SWT.RADIO);
		buttonRegistration.setBounds(134, 192, 94, 28);
		buttonRegistration.setText("Регистрация");

		setControl(container);
		AddListener();
	}
	private void AddListener() {
		combo.addListener(SWT.Selection, this);
		buttonLogon.addListener(SWT.Selection, this);
		buttonRegistration.addListener(SWT.Selection, this);
	}
	public IWizardPage getNextPage() {
		
		if(buttonLogon.getSelection()) {
			SelectDateReportPage page = ((LogonWizard)getWizard()).selectDateReportPage;
			return page;
		}
		if(buttonRegistration.getSelection()) {
			RegistrationPage page = ((LogonWizard)getWizard()).registrationPage;
			return page;
		}
		return null;
	}

	@Override
	public void handleEvent(Event event) {
		
	}
}
