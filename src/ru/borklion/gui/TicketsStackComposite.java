package ru.borklion.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import ru.borklion.TicketsStack;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TicketsStackComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	private static final int C = 0x2191;
	private static final int D = 0x2193;
	public TicketsStackComposite(Composite parent, int style) {
		super(parent, style);
		
		List listTickets = new List(this, SWT.BORDER);
		listTickets.setBounds(10, 10, 130, 251);
		TicketsStack.INSTANCE.addListener(new Observer() {

			@Override
			public void update(Observable o, Object arg) {
				listTickets.setItems((String[])arg);
			}
			
		});
		//list.setItems(TicketsStack.getTickets());
		
		Button btnAddButton = new Button(this, SWT.FLAT);
		btnAddButton.setBounds(10, 267, 28, 28);
		btnAddButton.setText("+");
		
		Button btnDeleteButton = new Button(this, SWT.FLAT);
		btnDeleteButton.setBounds(44, 267, 28, 28);
		btnDeleteButton.setText("-");
		
		Button btnUpButton = new Button(this, SWT.FLAT);
		btnUpButton.setBounds(78, 267, 28, 28);
		btnUpButton.setText(Character.toString((char)C));
		
		Button btnDownButton = new Button(this, SWT.FLAT);
		btnDownButton.setBounds(112, 267, 28, 28);
		btnDownButton.setText(Character.toString((char)D));

		btnAddButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddTicketDialog dialog = new AddTicketDialog(parent.getShell(), SWT.DIALOG_TRIM);
				if(dialog.open() == Boolean.TRUE) {
					TicketsStack.INSTANCE.AddTicket(new String[] {dialog.getText(),dialog.getText_1(),dialog.getText_2()});
				}
			}
		});

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
