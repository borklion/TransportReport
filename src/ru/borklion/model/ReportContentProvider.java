package ru.borklion.model;

import org.eclipse.jface.viewers.IStructuredContentProvider;

public class ReportContentProvider implements IStructuredContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
        if(inputElement instanceof TransportReportModel)
            return ((TransportReportModel)inputElement).getTrips().toArray();
        else return null;
	}

}
