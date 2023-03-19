package co.za.bbd.ars.service;

import co.za.bbd.ars.dtos.FlightData;
import co.za.bbd.ars.dtos.FlightDataResponse;
import co.za.bbd.ars.dtos.FlightFilters;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;

import java.util.Date;
import java.util.List;

public interface FlightService extends IService<Flight, Integer> {

    void deleteById(Integer id);

    List<Flight> findAll();

    FlightDataResponse createNewFlightPlan(FlightData flightData);

    List<FlightDataResponse> getFlights(FlightFilters flightFilters);

    List<Flight> getFlightsByFilters(FlightFilters filters);

    List<Ticket> getTicketsByFilters(Integer flightId, FlightFilters filters);

    Flight updateFlight(Integer flightId, Flight flight);
}
