package ru.borklion.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ru.borklion.dao.Employee;
import ru.borklion.dao.TransportReport;
import ru.borklion.dao.Trip;

public class TransportReportModel {
	private TransportReport transportReport;
	
	public TransportReportModel(Employee employee, int mounth, int year) {
		transportReport = new TransportReport(employee, mounth, year);
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
	
	public List<Trip> getTrips() {
		return transportReport.getTrips();
	}
}
