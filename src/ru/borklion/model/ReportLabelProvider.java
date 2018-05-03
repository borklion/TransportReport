package ru.borklion.model;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.LocalResourceManager;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import ru.borklion.dao.Trip;

public class ReportLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		
		if(columnIndex == TripsColumn.COLUMN_FLAGRETURNBASE_INDEX) {
			LocalResourceManager lrManager = new LocalResourceManager(JFaceResources.getResources(),
	                Display.getCurrent().getShells()[0]);
			ImageDescriptor imageDescriptorTrue = ImageDescriptor.createFromFile(
	                ReportLabelProvider.class,
	                "/ru/borklion/images/checktrue.png");
			Image imageTrue = lrManager.createImage(imageDescriptorTrue);
			ImageDescriptor imageDescriptorFalse = ImageDescriptor.createFromFile(
	                ReportLabelProvider.class,
	                "/ru/borklion/images/checkfalse.png");
			Image imageFalse = lrManager.createImage(imageDescriptorFalse);
			Trip trip = (Trip) element;
			if(trip.isFlagReturnBase()) {
				return new Image(Display.getCurrent(),imageTrue.getImageData(2));
			}
			else return new Image(Display.getCurrent(),imageFalse.getImageData(2));
		}
		else return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Trip trip = (Trip) element;
		String text = "";
		switch (columnIndex) {
		case TripsColumn.COLUMN_DATETRIP_INDEX:
			text = "" + trip.getDateTrip();
			break;
		case TripsColumn.COLUMN_IDREQUEST_INDEX:
			text = trip.getIdRequest();
			break;
		case TripsColumn.COLUMN_ADDRESS_INDEX:
			text = trip.getAddress();
			break;
		case TripsColumn.COLUMN_TRANSPORTTYPE_INDEX:
			text = trip.getTransportType();
			break;
		case TripsColumn.COLUMN_NUMBEROFBUSSTOP_INDEX:
			text = "" + trip.getNumberOfBusStop();
			break;
		case TripsColumn.COLUMN_FLAGRETURNBASE_INDEX:
			text = "";
			break;
		case TripsColumn.COLUMN_TICKETS_INDEX:
			text = trip.getTickets().toString();
			break;

		default:
			break;
		}
		return text;
	}

}
