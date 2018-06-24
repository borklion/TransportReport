package ru.borklion.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ru.borklion.dao.TransportReport;
import ru.borklion.dao.Trip;

public class TransportReportModel extends AbstractModel {
	private TransportReport transportReport;
	private int numberTickets;

	public TransportReportModel(Employee employee, int mounth, int year) {
		transportReport = new TransportReport(employee, mounth, year);
		numberTickets = 0;
	}
	
	public TransportReport getTransportReport() {
		return transportReport;
	}
	
	public void setTransportReport(TransportReport transportReport) {
		this.transportReport = transportReport;
		firePropertyChange("transportReport", null, null);
	}

	public void addTrip(String[] arg) {
		Date dateTrip;
		List<Trip> trips = transportReport.getTrips();
		try {
			dateTrip = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(arg[3]);
		} catch (ParseException e) {
			dateTrip = null;
		}
		trips.add(new Trip(arg[0], arg[2], dateTrip));
		transportReport.setTrips(trips);
	}

	public int getNumberTickets() {
		numberTickets = 0;
		for (Trip trip : transportReport.getTrips()) {
			numberTickets = +trip.getNumberOfBusStop();
		}
		return numberTickets;
	}
}
