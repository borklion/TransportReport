package ru.borklion.model;

import java.util.ArrayList;
import java.util.List;

public class TicketsStackModel extends AbstractModel{

	private List<Ticket> stackTickets;
	private int countTickets;

	public TicketsStackModel() {
		stackTickets = new ArrayList<Ticket>();
		countTickets = 0;
	}

	public List<Ticket> getStackTickets() {
		return stackTickets;
	}
	
	public void setStackTickets(List<Ticket> stackTickets) {
		this.stackTickets = stackTickets;
		countTickets = this.stackTickets.size();
		firePropertyChange("stackTickets", null, null);
		firePropertyChange("countTickets", null, null);
	}
	public int getCountTickets() {
		return countTickets;
	}
}