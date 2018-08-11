package ru.borklion.service;

import java.util.List;

import ru.borklion.model.Trip;

public interface IImportTrips {
	void addTrips(List<Trip> trips);
}
