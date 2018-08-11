package ru.borklion.service;

import ru.borklion.model.TransportReport;

public interface IAllocateTickets {
	void allocateTickets(TransportReport transportReport, TicketsStackImpl ticketStack);
}
