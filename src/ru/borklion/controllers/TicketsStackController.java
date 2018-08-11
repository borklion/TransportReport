package ru.borklion.controllers;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import ru.borklion.model.Ticket;
import ru.borklion.service.TicketsStackImpl;
import ru.borklion.service.TicketsStackService;
import ru.borklion.view.TicketsStackComposite;
import ru.borklion.view.dialogs.AddTicketDialog;

public class TicketsStackController {
	private TicketsStackService ticketsStack;
	private TicketsStackComposite ticketsStackComposit;
	private AddTicketDialog dialog;

	public TicketsStackController() {
		ticketsStack = new TicketsStackImpl();
		ticketsStackComposit.addAddButtonListener(addClickTicketsStackAddButton());
		ticketsStackComposit.addDeleteButtonListener(addClickTicketsStackDeleteButton());
	}

	public TicketsStackService getTicketsStack() {
		return ticketsStack;
	}

	public SelectionAdapter addClickTicketsStackAddButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dialog = new AddTicketDialog(ticketsStackComposit.getShell(), SWT.DIALOG_TRIM);
				Object result = dialog.open();
				if (result.equals(Boolean.TRUE)) {
					String[] fieldsDialog = dialog.getField();
					ticketsStack
							.addTicket(new Ticket(fieldsDialog[0], fieldsDialog[1], Integer.parseInt(fieldsDialog[2])));
					dialog.close();
				}
			}
		};
	}

	public SelectionAdapter addClickTicketsStackDeleteButton() {
		return new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ticketsStack.remove(ticketsStackComposit.getSelectionIndex());
			}
		};
	}
	// public KeyAdapter addPressedEnter() {
	// return new KeyAdapter() {
	// @Override
	// public void keyPressed(KeyEvent e) {
	// if (e.character == SWT.CR) {
	// dialog = new AddTicketDialog(shell, SWT.DIALOG_TRIM, ticketsStackModel);
	// dialog.open();
	// }
	// }
	// };
	// }

}
