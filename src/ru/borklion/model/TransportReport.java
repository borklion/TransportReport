package ru.borklion.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportReport extends AbstractModel {
	private Date dateReport;
	private Employee employee;
	private int reportingPeriod;
	private List<Trip> trips;

	public TransportReport() {

	}

	public TransportReport(Employee employee, int mounth, int year) {
		this.employee = employee;
		this.reportingPeriod = year * 100 + mounth;
		this.dateReport = new Date();
		this.trips = new ArrayList<Trip>();
	}

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

	public int getTotalSum() {
		int summa = 0;
		for (Trip trip : trips) {
			summa = summa + trip.getSummaTrip();
		}
		return summa;
	}

	public int getTotalNumberOfBusStop() {
		int number = 0;
		for (Trip trip : trips) {
			number = number + trip.getNumberOfBusStop();
		}
		return number;
	}

	public int getTotalNumberTickets() {
		int number = 0;
		for (Trip trip : trips) {
			number = number + trip.getNumberTickets();
		}
		return number;
	}

	public void setDateReport(Date dateReport) {
		firePropertyChange("dateReport", this.dateReport, dateReport);
		// this.dateReport = dateReport;
	}

	public void setEmployee(Employee employee) {
		firePropertyChange("employee", this.employee, employee);
		// this.employee = employee;
	}

	public void setReportingPeriod(int reportingPeriod) {
		firePropertyChange("reportingPeriod", this.reportingPeriod, reportingPeriod);
		// this.reportingPeriod = reportingPeriod;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
		firePropertyChange("trips", null, null);
	}

	public void addTrip(String[] arg) {
		Date dateTrip;
		try {
			dateTrip = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(arg[3]);
		} catch (ParseException e) {
			dateTrip = null;
		}
		trips.add(new Trip(arg[0], arg[2], dateTrip));
		firePropertyChange("trips", null, null);
	}
}
