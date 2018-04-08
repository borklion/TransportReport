package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import org.eclipse.swt.widgets.Button;

public class TripsComposite extends Composite {
	private Button btnNewButton;
	private Table table;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TripsComposite(Composite parent, int style) {
		super(parent, style);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setBounds(110, 17, 59, 14);
		lblNewLabel.setText("New Label");
		
		table = new Table(this, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 44, 18, 34);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		
		btnNewButton = new Button(this, SWT.NONE);
//		btnNewButton.addSelectionListener(new SelectionAdapter() {

//		});
		btnNewButton.setBounds(10, 10, 94, 28);
		btnNewButton.setText("New Button");

	}
	
	public Button getNewButton() {
		return btnNewButton;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
