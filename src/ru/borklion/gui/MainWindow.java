package ru.borklion.gui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import ru.borklion.Employees;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;

public class MainWindow {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(700, 400);
		shell.setText("SWT Application");
		Employees employees = new Employees();
		
		Combo comboTerBank = new Combo(shell, SWT.READ_ONLY);
		comboTerBank.setItems(employees.getTerBanks());
		comboTerBank.setBounds(10, 10, 200, 22);
		
		Combo comboGOSB = new Combo(shell, SWT.READ_ONLY);
		comboGOSB.setEnabled(false);
		comboGOSB.setBounds(216, 10, 200, 22);
		
		Combo comboEmpl = new Combo(shell, SWT.READ_ONLY);
		comboEmpl.setEnabled(false);
		comboEmpl.setBounds(422, 10, 200, 22);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER | SWT.SHORT);
		dateTime.setBounds(126, 38, 84, 22);
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		label.setBounds(216, 38, 59, 22);
		label.setText("Декада");
		
		Combo combo = new Combo(shell, SWT.READ_ONLY);
		combo.setItems(new String[] {"1", "2", "3"});
		combo.setBounds(281, 38, 135, 22);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		label_1.setBounds(10, 38, 110, 22);
		label_1.setText("Отчетный месяц");
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(10, 66, 116, 28);
		button.setText("Создать отчет");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		label_2.setBounds(422, 38, 123, 22);
		label_2.setText("Количество заявок: ");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 12, SWT.NORMAL));
		label_3.setBounds(422, 66, 128, 22);
		label_3.setText("Количество билетов:");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 14, SWT.NORMAL));
		label_4.setBounds(563, 38, 59, 22);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 14, SWT.NORMAL));
		label_5.setBounds(563, 66, 59, 22);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 100, 18, 34);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		comboTerBank.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				comboGOSB.setItems(employees.getGOSBs(comboTerBank.getItem(comboTerBank.getSelectionIndex())));
				comboGOSB.setEnabled(true);
				comboEmpl.removeAll();;
				comboEmpl.setEnabled(false);
			}
		});
		comboGOSB.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				comboEmpl.setItems(employees.getEmployees(comboGOSB.getItem(comboGOSB.getSelectionIndex())));
				comboEmpl.setEnabled(true);
			}
		});
		comboEmpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
	}
}
