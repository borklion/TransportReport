package ru.borklion.view;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import ru.borklion.model.TransportReport;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.observable.sideeffect.ISideEffect;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.widgets.Button;

public class TripsComposite extends Composite {
	private Button btnNewButton;
	private TripsViewer tripsViewer;
	private Label labelTrips;
	private TransportReport model;
//	private DataBindingContext m_bindingContext;

	public TripsComposite(Composite parent, int style) {
		super(parent, style);
		
//		Label label = new Label(this, SWT.NONE);
//		label.setBounds(146, 10, 113, 28);
//		label.setText("Требуется билетов");

		labelTrips = new Label(this, SWT.NONE);
		labelTrips.setBounds(265, 10, 400, 28);
		labelTrips.setText("00000000000000000000000");
		
		tripsViewer = new TripsViewer(this,SWT.BORDER|SWT.V_SCROLL|SWT.FULL_SELECTION);
		tripsViewer.getTable().setBounds(10, 54, 700, 200);
		
		btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setBounds(10, 10, 130, 28);
		btnNewButton.setText("Загрузить XML");
		
		IObservableValue countTicketsModelObserveValue = BeanProperties.value("trips").observe(model);
		ISideEffect sideEffect =
				  ISideEffect.create(
				       () -> {return "Количество необходимых билетов: " + model.getTotalNumberOfBusStop();},
				       labelTrips::setText);
//		m_bindingContext = initDataBindings();
	}
	
	public void addImportButtonListener(SelectionAdapter listener) {
		btnNewButton.addSelectionListener(listener);
	}
	
	public TripsViewer getTripsViewer() {
		return tripsViewer;
	}
//	public void setLabelText(String text) {
//		labelTrips.setText(text);;
//	}
	public void setModel(TransportReport model) {
		tripsViewer.setInput(model);
		this.model = model;
	}
//	protected DataBindingContext initDataBindings() {
//		DataBindingContext bindingContext = new DataBindingContext();
//		//
//		IObservableValue observeTextLblNumberTicketsObserveWidget_1 = WidgetProperties.text().observe(labelTrips);
//		IObservableValue countTicketsModelObserveValue = BeanProperties.value("numberTickets").observe(model);
//		bindingContext.bindValue(observeTextLblNumberTicketsObserveWidget_1, countTicketsModelObserveValue, null, null);
//		//
//		return bindingContext;
//	}
	@Override
	protected void checkSubclass() {
	}
}
