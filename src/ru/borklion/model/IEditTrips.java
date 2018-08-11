package ru.borklion.model;

public interface IEditTrips {
	void addTrip(Trip trip);
	void removeTrip(Trip trip);
	void editAddress(Trip trip, String address);
	void editNumberOfBusStop(Trip trip, int numberOfBusStop);
	void editFlagReturnBase(Trip trip, boolean flagReturnBase);
	void editTransportType(Trip trip, TransportType transportType);
}
