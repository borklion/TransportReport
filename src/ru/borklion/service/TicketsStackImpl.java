package ru.borklion.service;

import java.util.ArrayList;
import java.util.List;

import ru.borklion.model.Ticket;

public class TicketsStackImpl implements TicketsStackService {

	private List<Ticket> tickets;
	// private int countTickets;

	public TicketsStackImpl() {
		tickets = new ArrayList<Ticket>();
		// countTickets = 0;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	// public void setStackTickets(List<Ticket> stackTickets) {
	// this.stackTickets = stackTickets;
	// countTickets = this.stackTickets.size();
	// firePropertyChange("stackTickets", null, null);
	// firePropertyChange("countTickets", null, null);
	// }
	public int getCountTickets() {
		return tickets.size();
	}

	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
	}

	public void addTickets(List<Ticket> tickets) {
		tickets.addAll(tickets);
	}

	public void remove(int index) {
		tickets.remove(index);
	}

	public void removeAll() {
		tickets.clear();
	}
}