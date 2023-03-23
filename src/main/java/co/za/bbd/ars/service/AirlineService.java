package co.za.bbd.ars.service;

import co.za.bbd.ars.model.Airline;

public interface AirlineService extends IService<Airline, Integer> {
    Airline updateAirline(Integer airlineId, Airline airline);
}
