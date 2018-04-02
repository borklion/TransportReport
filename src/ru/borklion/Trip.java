package ru.borklion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Trip {
	private Date dateTrip;
	private String idRequest;
	private String address;
	private List<Ticket> tickets;
	private boolean flagReturnBase;
	
	public Trip(String idRequest, String address, Date dateTrip) {
		this.idRequest = idRequest;
		this.address = address;
		this.dateTrip = dateTrip;
		this.tickets = new ArrayList<Ticket>();
		this.flagReturnBase = true;
	}
}
