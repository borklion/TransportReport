package ru.borklion.view.dialogs;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class SelectDateReportPage extends WizardPage implements Listener {
	private DateTime dateTime;
	/**
	 * Create the wizard.
	 */
	public SelectDateReportPage() {
		super("wizardPage");
		setTitle("Вход");
		setDescription("Выберите отчетный месяц");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		dateTime = new DateTime(container, SWT.BORDER | SWT.SHORT);
		dateTime.setBounds(10, 10, 89, 27);
		setControl(container);
		AddListener();
	}
	private void AddListener() {
		dateTime.addListener(SWT.Selection, this);
	}

	public int[] getDateSelected() {
		return new int[] {dateTime.getMonth(),dateTime.getYear()};
	}
	@Override
	public void handleEvent(Event event) {
		if(event.widget.equals(dateTime)) {
			if(dateTime.getMonth()>0 && dateTime.getYear()>2000) {
				
			}
		}
		setPageComplete(isPageComplete());
		getWizard().getContainer().updateButtons();
	}

}
