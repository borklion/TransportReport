package ru.borklion.service;

import ru.borklion.model.TransportType;
import ru.borklion.model.Trip;

public interface IEditTrips {
	void addTrip(Trip trip);
	void removeTrip(Trip trip);
	void editAddress(Trip trip, String address);
	void editNumberOfBusStop(Trip trip, int numberOfBusStop);
	void editFlagReturnBase(Trip trip, boolean flagReturnBase);
	void editTransportType(Trip trip, TransportType transportType);
}
