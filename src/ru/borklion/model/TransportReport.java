package ru.borklion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportReport {
	private Date dateReport;
	private Employee employee;
	private int reportingPeriod;
	private List<Trip> trips;
	private int total;
	
	public TransportReport(Employee employee, int mounth, int year) {
		super();
		this.employee = employee;
		this.reportingPeriod = year*100 + mounth;
		this.dateReport = new Date();
		this.trips = new ArrayList<Trip>();
		this.total = 0;
	}
	
	public void addTrip(String idRequest, String address, Date dateTrip) {
		Trip trip = new Trip(idRequest, address, dateTrip);
		this.trips.add(trip);
	}
	
	
}