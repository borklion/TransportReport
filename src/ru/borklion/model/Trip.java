package ru.borklion.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip extends AbstractModel {
	private Date dateTrip;
	private String idRequest;
	private String address;
	private TransportType transportType;
	private int numberOfBusStop;
	private List<Ticket> tickets;
	private boolean flagReturnBase;

	public Trip() {

	}

	public Trip(String idRequest, String address, Date dateTrip) {
		this.idRequest = idRequest;
		this.address = address;
		this.dateTrip = dateTrip;
		this.transportType = TransportType.Автобус;
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

	public TransportType getTransportType() {
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

	public int getSummaTrip() {
		int summa = 0;
		for (Ticket ticket : tickets) {
			summa = summa + ticket.getPrice();
		}
		return summa;
	}

	public int getNumberTickets() {
		return tickets.size();
	}

	public void setDateTrip(Date dateTrip) {
		firePropertyChange("dateTrip", this.dateTrip, dateTrip);
		// this.dateTrip = dateTrip;
	}

	public void setIdRequest(String idRequest) {
		firePropertyChange("idRequest", this.idRequest, idRequest);
		// this.idRequest = idRequest;
	}

	public void setAddress(String address) {
		firePropertyChange("address", this.address, address);
		// this.address = address;
	}

	public void setTransportType(String transportType) {
		firePropertyChange("transportType", this.transportType, transportType);
		// this.transportType = transportType;
	}

	public void setNumberOfBusStop(int numberOfBusStop) {
		firePropertyChange("numberOfBusStop", this.numberOfBusStop, numberOfBusStop);
		// this.numberOfBusStop = numberOfBusStop;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
		firePropertyChange("tickets", null, null);
	}

	public void setFlagReturnBase(boolean flagReturnBase) {
		// this.flagReturnBase = flagReturnBase;
		firePropertyChange("flagReturnBase", this.flagReturnBase, flagReturnBase);
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		firePropertyChange("tickets", null, null);
	}

	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		firePropertyChange("tickets", null, null);
	}
}
