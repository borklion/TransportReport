package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

import ru.borklion.model.TicketsStack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;
import org.eclipse.jface.viewers.ListViewer;

import org.eclipse.core.databinding.property.Properties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.swt.widgets.Label;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.core.databinding.beans.PojoProperties;

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
	private TicketsStack model;
	private List list;
	private ListViewer listViewer;
	private Label lblNumberTickets;
	private Label label;
	
	public TicketsStackComposite(Composite parent, int style) {
		super(parent, style);
		lblNumberTickets = new Label(this, SWT.NONE);
		lblNumberTickets.setBounds(81, 10, 59, 39);
		
		btnAddButton = new Button(this, SWT.FLAT);
		btnAddButton.setBounds(10, 312, 28, 28);
		btnAddButton.setText("+");
		
		btnDeleteButton = new Button(this, SWT.FLAT);
		btnDeleteButton.setBounds(44, 312, 28, 28);
		btnDeleteButton.setText("-");
		
		btnUpButton = new Button(this, SWT.FLAT);
		btnUpButton.setBounds(78, 312, 28, 28);
		btnUpButton.setText(Character.toString((char)C));
		
		btnDownButton = new Button(this, SWT.FLAT);
		btnDownButton.setBounds(112, 312, 28, 28);
		btnDownButton.setText(Character.toString((char)D));
		model = new TicketsStack();
		listViewer = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
		list = listViewer.getList();
		list.setBounds(10, 55, 130, 251);
		ViewerSupport.bind(listViewer,
				BeanProperties.list(model.getClass(), "stackTickets", String.class).observe(model),
				Properties.selfValue(String.class));
		
		label = new Label(this, SWT.NONE);
		label.setBounds(10, 10, 59, 39);
		label.setText("Билетов:");
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
	
	public TicketsStack getModel() {
		return model;
	}
	
	public int getSelectionIndex() {
		return list.getSelectionIndex();
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue observeTextLblNumberTicketsObserveWidget_1 = WidgetProperties.text().observe(lblNumberTickets);
		IObservableValue countTicketsModelObserveValue = BeanProperties.value("countTickets").observe(model);
		bindingContext.bindValue(observeTextLblNumberTicketsObserveWidget_1, countTicketsModelObserveValue, null, null);
		//
		return bindingContext;
	}
}
