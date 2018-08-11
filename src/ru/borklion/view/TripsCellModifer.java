package ru.borklion.view;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Item;

import ru.borklion.model.Trip;
import ru.borklion.model.TripsColumn;

public class TripsCellModifer implements ICellModifier {
	private TableViewer tv;
	
	public TripsCellModifer(TableViewer tv) {
		this.tv = tv;
	}
	
	@Override
	public boolean canModify(Object element, String property) {
		if(TripsColumn.ADDRESS.equals(property) || TripsColumn.FLAGRETURNBASE.equals(property) || TripsColumn.NUMBEROFBUSSTOP.equals(property) || TripsColumn.TRANSPORTTYPE.equals(property)) {
			return true;
		}
		else return false;
	}

	@Override
	public Object getValue(Object element, String property) {
		Trip trip = (Trip) element;
		if(TripsColumn.DATETRIP.equals(property)) {
			return trip.getDateTrip();
		}
		else if(TripsColumn.IDREQUEST.equals(property)) {
			return trip.getIdRequest();
		}
		else if(TripsColumn.ADDRESS.equals(property)) {
			return trip.getAddress();
		}
		else if(TripsColumn.TRANSPORTTYPE.equals(property)) {
			return trip.getTransportType();
		}
		else if(TripsColumn.NUMBEROFBUSSTOP.equals(property)) {
			return trip.getNumberOfBusStop();
		}
		else if(TripsColumn.FLAGRETURNBASE.equals(property)) {
			return trip.isFlagReturnBase();
		}
		else if(TripsColumn.TICKETS.equals(property)) {
			return trip.getTickets();
		}
		else
			return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if(element instanceof Item) element = ((Item) element).getData();
		Trip trip = (Trip) element;
		if(TripsColumn.ADDRESS.equals(property)) {
			trip.setAddress((String) value);
		}
		else if(TripsColumn.TRANSPORTTYPE.equals(property)) {
			trip.setTransportType((String) value);
		}
		else if(TripsColumn.NUMBEROFBUSSTOP.equals(property)) {
			trip.setNumberOfBusStop(((Integer) value).intValue());
		}
		else if(TripsColumn.FLAGRETURNBASE.equals(property)) {
			trip.setFlagReturnBase(((Boolean) value).booleanValue());
		}
		tv.refresh();
	}

}
