package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class TripsComposite extends Composite {
	private Button btnNewButton;
	private TripsViewer tripsViewer;

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
		
		tripsViewer = new TripsViewer(this,SWT.BORDER|SWT.V_SCROLL|SWT.FULL_SELECTION);
		tripsViewer.getTable().setBounds(10, 54, 700, 200);
		
		btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 10, 94, 28);
		btnNewButton.setText("New Button");

	}
	
	public Button getNewButton() {
		return btnNewButton;
	}
	
	public TripsViewer getTripsViewer() {
		return tripsViewer;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
