package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;

public class TicketsStackComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	private static final int C = 0x2191;
	private static final int D = 0x2193;
	private Button btnAddButton;
	private Button btnDeleteButton;
	private Button btnUpButton;
	private Button btnDownButton;
	private List listTickets;
	
	public TicketsStackComposite(Composite parent, int style) {
		super(parent, style);
		
		listTickets = new List(this, SWT.BORDER);
		listTickets.setBounds(10, 10, 130, 251);

		
		btnAddButton = new Button(this, SWT.FLAT);
		btnAddButton.setBounds(10, 267, 28, 28);
		btnAddButton.setText("+");
		
		btnDeleteButton = new Button(this, SWT.FLAT);
		btnDeleteButton.setBounds(44, 267, 28, 28);
		btnDeleteButton.setText("-");
		
		btnUpButton = new Button(this, SWT.FLAT);
		btnUpButton.setBounds(78, 267, 28, 28);
		btnUpButton.setText(Character.toString((char)C));
		
		btnDownButton = new Button(this, SWT.FLAT);
		btnDownButton.setBounds(112, 267, 28, 28);
		btnDownButton.setText(Character.toString((char)D));

	}
	
	public Button getAddButton() {
		return btnAddButton;
	}
	
	public Button getDeleteButton() {
		return btnDeleteButton;
	}
	
	public Button getUpButton() {
		return btnUpButton;
	}
	
	public Button getDownButton() {
		return btnDownButton;
	}
	
	public List getListTickets() {
		return listTickets;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
