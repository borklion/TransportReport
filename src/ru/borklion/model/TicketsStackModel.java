package ru.borklion.model;

import java.util.ArrayList;
import java.util.List;
import ru.borklion.dao.Ticket;

public class TicketsStackModel extends AbstractModel {
	
	private List<Ticket> stackTickets;
	
	public TicketsStackModel() {
		stackTickets = new ArrayList<Ticket>();
	}
	
	public List<Ticket> getTickets() {
//		String[] array = new String[stackTickets.size()];
//		int i = 0;
//		for(Ticket ticket:stackTickets) {
//			array[i] = ticket.getSerial() + " " + ticket.getNumber() + " " + ticket.getPrice();
//			i++;
//		}
		return stackTickets;
	}
	public void AddTicket(String[] t) {
		if (t.length==3) {
			stackTickets.add(new Ticket(t[0],t[1],Integer.parseInt(t[2])));
		} else throw new NumberFormatException();
//		this.notifyObservers(this.getTickets());
	}
	
	public void DeleteTicket(int t) {
		stackTickets.remove(t);
//		this.notifyObservers(this.getTickets());
	}
}
