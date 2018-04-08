package ru.borklion.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ru.borklion.dao.Employee;
import ru.borklion.dao.TransportReport;
import ru.borklion.dao.Trip;

public class TransportReportModel {
	private TransportReport transportReport;
	private List<Trip> trips = new ArrayList<>();
	
	public TransportReportModel(Employee employee, int mounth, int year) {
		this.transportReport = new TransportReport(employee, mounth, year);
	}
	
	public void addTrip(String[] arg) {
	Date dateTrip;
	try {
		dateTrip = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(arg[3]);
	} catch (ParseException e) {
		dateTrip = null;
	}
	trips.add(new Trip(arg[0],arg[2],dateTrip));
	this.transportReport.setTrips(trips);
}
}
