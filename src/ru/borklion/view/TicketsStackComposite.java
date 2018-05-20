package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import ru.borklion.model.TicketsStackModel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.BeanProperties;

public class TicketsStackComposite extends Composite {
	private DataBindingContext m_bindingContext;

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
	private TicketsStackModel model;
	
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
		m_bindingContext = initDataBindings();

	}
	
	public void addAddButtonListener(SelectionAdapter listener) {
		btnAddButton.addSelectionListener(listener);
	}
	
	public void addDeleteButtonListener(SelectionAdapter listener) {
		btnDeleteButton.addSelectionListener(listener);
	}
	
	public void addUpButtonListener(SelectionAdapter listener) {
		btnUpButton.addSelectionListener(listener);
	}
	
	public void addDownButtonListener(SelectionAdapter listener) {
		btnDownButton.addSelectionListener(listener);
	}
	
	public void setModel(TicketsStackModel model) {
		this.model = model;
	}
	
	public int getSelectionIndex() {
		return listTickets.getSelectionIndex();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

//	@Override
//	public void update(Observable o, Object arg) {
//		listTickets.setItems((String[]) arg);
//	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableList itemsListTicketsObserveWidget = WidgetProperties.items().observe(listTickets);
		IObservableList ticketsModelObserveList = BeanProperties.list("tickets").observe(model);
		bindingContext.bindList(itemsListTicketsObserveWidget, ticketsModelObserveList, null, null);
		//
		return bindingContext;
	}
}
