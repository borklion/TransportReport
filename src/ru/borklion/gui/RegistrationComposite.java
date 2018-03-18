package ru.borklion.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import ru.borklion.TransportReportController;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RegistrationComposite extends Composite {
	private Text textFIO;
	private Text textDepartment;
	private Text textBoss;
	private Text textAccountant;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public RegistrationComposite(Composite parent, int style) {
		super(parent, style);
		
		Label lblFIO = new Label(this, SWT.NONE);
		lblFIO.setBounds(10, 10, 100, 14);
		lblFIO.setText("ФИО");
		
		Label lblDepartment = new Label(this, SWT.NONE);
		lblDepartment.setBounds(10, 30, 100, 14);
		lblDepartment.setText("Подразделение");
		
		Label lblBoss = new Label(this, SWT.NONE);
		lblBoss.setBounds(10, 50, 100, 14);
		lblBoss.setText("Начальник");
		
		Label lblAccountant = new Label(this, SWT.NONE);
		lblAccountant.setBounds(10, 70, 100, 14);
		lblAccountant.setText("Бухгалтер");
		
		textFIO = new Text(this, SWT.BORDER);
		textFIO.setBounds(116, 5, 300, 19);
		
		textDepartment = new Text(this, SWT.BORDER);
		textDepartment.setBounds(116, 25, 300, 19);
		
		textBoss = new Text(this, SWT.BORDER);
		textBoss.setBounds(116, 45, 300, 19);
		
		textAccountant = new Text(this, SWT.BORDER);
		textAccountant.setBounds(116, 65, 300, 19);
		
		Button buttonSave = new Button(this, SWT.NONE);
		buttonSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransportReportController.SaveEmployee(textFIO.getText(),textDepartment.getText(),textBoss.getText(),textAccountant.getText());
			}
		});
		buttonSave.setBounds(116, 90, 94, 28);
		buttonSave.setText("Сохранить");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
