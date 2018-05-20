package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import ru.borklion.model.TransportReportModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;

public class TripsComposite extends Composite {
	private Button btnNewButton;
	private TripsViewer tripsViewer;
	private Label labelTrips;
	private TransportReportModel model;

	public TripsComposite(Composite parent, int style) {
		super(parent, style);
		
		labelTrips = new Label(this, SWT.NONE);
		labelTrips.setBounds(146, 10, 564, 28);
		labelTrips.setText("");
		
		tripsViewer = new TripsViewer(this,SWT.BORDER|SWT.V_SCROLL|SWT.FULL_SELECTION);
		tripsViewer.getTable().setBounds(10, 54, 700, 200);
		tripsViewer.setInput(model);
		
		btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 10, 130, 28);
		btnNewButton.setText("Загрузить XML");
		
	}
	
	public void addImportButtonListener(SelectionAdapter listener) {
		btnNewButton.addSelectionListener(listener);
	}
	
	public TripsViewer getTripsViewer() {
		return tripsViewer;
	}
	public void setLabelText(String text) {
		labelTrips.setText(text);;
	}
	public void setModel(TransportReportModel model) {
		this.model = model;
	}
	@Override
	protected void checkSubclass() {
	}
}
