package ru.borklion.model;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.SWTResourceManager;

public class ReportLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if(columnIndex == 5) {
			Trip trip = (Trip) element;
			if(trip.isFlagReturnBase()) {
				return new Image(Display.getCurrent(),SWTResourceManager.getImage(ReportLabelProvider.class, "/ru/borklion/images/checktrue.png").getImageData(2));
			}
			else return new Image(Display.getCurrent(),SWTResourceManager.getImage(ReportLabelProvider.class, "/ru/borklion/images/checkfalse.png").getImageData(2));
		}
		else return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Trip trip = (Trip) element;
		String text = "";
		switch (columnIndex) {
		case 0:
			text = "" + trip.getDateTrip();
			break;
		case 1:
			text = trip.getIdRequest();
			break;
		case 2:
			text = trip.getAddress();
			break;
		case 3:
			text = trip.getTransportType().toString();
			break;
		case 4:
			text = "" + trip.getNumberOfBusStop();
			break;
		case 5:
			text = "";
			break;
		case 6:
			text = trip.getTickets().toString();
			break;

		default:
			break;
		}
		return text;
	}

}
