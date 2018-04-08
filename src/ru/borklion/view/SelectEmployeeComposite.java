package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class SelectEmployeeComposite extends Composite {
	private Combo combo;
	private Button buttonLogon;
	private Button buttonRegistration;
	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SelectEmployeeComposite(Composite parent, int style) {
		super(parent, style);
		
		combo = new Combo(this, SWT.NONE);
		combo.setBounds(155, 10, 140, 22);
		
		buttonLogon = new Button(this, SWT.NONE);
		buttonLogon.setBounds(178, 38, 94, 28);
		buttonLogon.setText("Вход");
		
		buttonRegistration = new Button(this, SWT.NONE);
		buttonRegistration.setBounds(178, 72, 94, 28);
		buttonRegistration.setText("Регистрация");

	}
	
	public Button getButtonRegistration() {
		return this.buttonRegistration;
	}
	
	public Button getButtonLogon() {
		return this.buttonLogon;
	}
	
	public Combo getCombo() {
		return this.combo;
	}
	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
