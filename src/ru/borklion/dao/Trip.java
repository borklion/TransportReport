package ru.borklion.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip {
	private Date dateTrip;
	private String idRequest;
	private String address;
	private String transportType;
	private int numberOfBusStop;
	private List<Ticket> tickets;
	private boolean flagReturnBase;
	
	public Trip(String idRequest, String address, Date dateTrip) {
		this.idRequest = idRequest;
		this.address = address;
		this.dateTrip = dateTrip;
		this.transportType = "Автобус";
		this.numberOfBusStop = 1;
		this.tickets = new ArrayList<Ticket>();
		this.flagReturnBase = true;
	}

	public Date getDateTrip() {
		return dateTrip;
	}

	public String getIdRequest() {
		return idRequest;
	}

	public String getAddress() {
		return address;
	}
	public String getTransportType() {
		return transportType;
	}
	public int getNumberOfBusStop() {
		return numberOfBusStop;
	}
	public List<Ticket> getTickets() {
		return tickets;
	}

	public boolean isFlagReturnBase() {
		return flagReturnBase;
	}

	public void setDateTrip(Date dateTrip) {
		this.dateTrip = dateTrip;
	}

	public void setIdRequest(String idRequest) {
		this.idRequest = idRequest;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}
	public void setNumberOfBusStop(int numberOfBusStop) {
		this.numberOfBusStop = numberOfBusStop;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public void setFlagReturnBase(boolean flagReturnBase) {
		this.flagReturnBase = flagReturnBase;
	}
}
