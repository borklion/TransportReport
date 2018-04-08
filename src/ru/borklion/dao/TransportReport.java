package ru.borklion.dao;

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
	
//	public void addTrip(String idRequest, String address, Date dateTrip) {
//		Trip trip = new Trip(idRequest, address, dateTrip);
//		this.trips.add(trip);
//	}

	public Date getDateReport() {
		return dateReport;
	}

	public Employee getEmployee() {
		return employee;
	}

	public int getReportingPeriod() {
		return reportingPeriod;
	}

	public List<Trip> getTrips() {
		return trips;
	}

	public int getTotal() {
		return total;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setReportingPeriod(int reportingPeriod) {
		this.reportingPeriod = reportingPeriod;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
