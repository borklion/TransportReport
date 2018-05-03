package ru.borklion.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ru.borklion.dao.Ticket;

public enum TicketsStack {
	INSTANCE;
	
	private List<Ticket> stackTickets = new ArrayList<Ticket>();
	
	private List<Observer> listener = new ArrayList<>();
	
	private Observable o = new Observable();

	public String[] getTickets() {
		String[] array = new String[stackTickets.size()];
		int i = 0;
		for(Ticket ticket:stackTickets) {
			array[i] = ticket.getSerial() + " " + ticket.getNumber() + " " + ticket.getPrice();
			i++;
		}
		return array;
	}
	public void AddTicket(String[] t) {
		if (t.length==3) {
			this.stackTickets.add(new Ticket(t[0],t[1],Integer.parseInt(t[2])));
		} else throw new NumberFormatException();
		this.notifyListener();
	}
	
	public void DeleteTicket(int t) {
		stackTickets.remove(t);
		this.notifyListener();
	}
	
	public void notifyListener() {
		for(Observer o:this.listener) {
			o.update(this.o, this.getTickets());
		}
	}
	
	public void addListener(Observer o) {
		this.listener.add(o);
	}
}
