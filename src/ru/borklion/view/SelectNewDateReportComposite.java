package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class SelectNewDateReportComposite extends Composite {
	private Button button;
	private DateTime dateTime;

	public SelectNewDateReportComposite(Composite parent, int style) {
		super(parent, style);
		
		dateTime = new DateTime(this, SWT.BORDER | SWT.SHORT);
		dateTime.setBounds(10, 10, 89, 27);
		
		button = new Button(this, SWT.NONE);
		button.setBounds(105, 10, 150, 28);
		button.setText("Создать отчет");

	}
	
	public Button getButton() {
		return this.button;
	}
	
	public DateTime getDateReport() {
		return this.dateTime;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
