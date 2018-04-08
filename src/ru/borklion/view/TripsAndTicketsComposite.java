package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;

public class TripsAndTicketsComposite extends Composite {
	private TripsComposite tripsComposite;
	private TicketsStackComposite ticketsStackComposite;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TripsAndTicketsComposite(Composite parent, int style) {
		super(parent, style);
		
		tripsComposite = new TripsComposite(this, SWT.NONE);
		tripsComposite.setBounds(10, 10, 64, 64);
		
		ticketsStackComposite = new TicketsStackComposite(this, SWT.NONE);
		ticketsStackComposite.setBounds(300, 10, 140, 295);

	}
	
	public TripsComposite getTripsComposite() {
		return tripsComposite;
	}
	
	public TicketsStackComposite getTicketsStackComposite() {
		return ticketsStackComposite;
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
