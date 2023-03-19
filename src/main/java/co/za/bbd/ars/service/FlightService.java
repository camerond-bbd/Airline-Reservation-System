package co.za.bbd.ars.service;

import co.za.bbd.ars.dtos.FlightData;
import co.za.bbd.ars.dtos.FlightDataResponse;
import co.za.bbd.ars.dtos.FlightFilters;
import co.za.bbd.ars.model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService extends IService<Flight, Integer> {

    void deleteById(Integer id);

    List<Flight> findAll();

    FlightDataResponse createNewFlightPlan(FlightData flightData);

    List<FlightDataResponse> getFlights(FlightFilters flightFilters);
}
