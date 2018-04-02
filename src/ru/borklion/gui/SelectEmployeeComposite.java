package ru.borklion.gui;

import org.eclipse.swt.widgets.Composite;

import ru.borklion.TransportReportController;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SelectEmployeeComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SelectEmployeeComposite(Composite parent, int style) {
		super(parent, style);
		
		Combo combo = new Combo(this, SWT.NONE);
		combo.setBounds(155, 10, 140, 22);
		
		Button buttonLogon = new Button(this, SWT.NONE);
		buttonLogon.setBounds(178, 38, 94, 28);
		buttonLogon.setText("Вход");
		
		Button buttonRegistration = new Button(this, SWT.NONE);
		buttonRegistration.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				RegistrationComposite registrationComposite = new RegistrationComposite(parent, SWT.NONE);
				TransportReportController.ViewCompositeStackLayout(parent, registrationComposite);
			}
		});
		buttonRegistration.setBounds(178, 72, 94, 28);
		buttonRegistration.setText("Регистрация");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
