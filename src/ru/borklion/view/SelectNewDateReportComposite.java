package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;

import ru.borklion.controllers.TransportReportController;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class SelectNewDateReportComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public SelectNewDateReportComposite(Composite parent, int style) {
		super(parent, style);
		
		DateTime dateTime = new DateTime(this, SWT.BORDER | SWT.SHORT);
		dateTime.setBounds(10, 10, 89, 27);
		
		Button button = new Button(this, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TransportReportController.CreateReport(dateTime.getMonth(),dateTime.getYear());
				TripsAndTicketsComposite tripsAndTicketsComposite = new TripsAndTicketsComposite(parent, SWT.NONE);
				TransportReportController.ViewCompositeStackLayout(parent, tripsAndTicketsComposite);
			}
		});
		button.setBounds(105, 10, 150, 28);
		button.setText("Создать отчет");

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
