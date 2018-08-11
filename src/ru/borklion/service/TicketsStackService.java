package ru.borklion.service;

import java.util.List;

import ru.borklion.model.Ticket;

public interface TicketsStackService {
	List<Ticket> getTickets();
	int getCountTickets();
	void addTicket(Ticket ticket);
	void addTickets(List<Ticket> tickets);
	void remove(int index);
	void removeAll();
}
