package ru.borklion.view.dialogs;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RegistrationPage extends WizardPage {
	private Text textFIO;
	private Text textDepartment;
	private Text textBoss;
	private Text textAccountant;

	/**
	 * Create the wizard.
	 */
	public RegistrationPage() {
		super("wizardPage");
		setTitle("Регистрация");
		setDescription("Заполните поля");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		Label lblFIO = new Label(container, SWT.NONE);
		lblFIO.setBounds(10, 10, 100, 14);
		lblFIO.setText("ФИО");
		
		Label lblDepartment = new Label(container, SWT.NONE);
		lblDepartment.setBounds(10, 30, 100, 14);
		lblDepartment.setText("Подразделение");
		
		Label lblBoss = new Label(container, SWT.NONE);
		lblBoss.setBounds(10, 50, 100, 14);
		lblBoss.setText("Начальник");
		
		Label lblAccountant = new Label(container, SWT.NONE);
		lblAccountant.setBounds(10, 70, 100, 14);
		lblAccountant.setText("Бухгалтер");
		
		textFIO = new Text(container, SWT.BORDER);
		textFIO.setBounds(116, 5, 300, 19);
		
		textDepartment = new Text(container, SWT.BORDER);
		textDepartment.setBounds(116, 25, 300, 19);
		
		textBoss = new Text(container, SWT.BORDER);
		textBoss.setBounds(116, 45, 300, 19);
		
		textAccountant = new Text(container, SWT.BORDER);
		textAccountant.setBounds(116, 65, 300, 19);
		setControl(container);
	}

}
