package ru.borklion.gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

public class TripsAndTicketsComposite extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TripsAndTicketsComposite(Composite parent, int style) {
		super(parent, style);
		
		TripsComposite tripsComposite = new TripsComposite(this, SWT.NONE);
		tripsComposite.setBounds(10, 10, 64, 64);
		
		TicketsStackComposite ticketsStackComposite = new TicketsStackComposite(this, SWT.NONE);
		ticketsStackComposite.setBounds(300, 10, 140, 295);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
