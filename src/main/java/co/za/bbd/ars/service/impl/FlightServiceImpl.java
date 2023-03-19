package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.dtos.FlightData;
import co.za.bbd.ars.dtos.FlightDataResponse;
import co.za.bbd.ars.dtos.FlightFilters;
import co.za.bbd.ars.dtos.FlightTicketData;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.repository.FlightRepository;
import co.za.bbd.ars.service.FlightService;
import co.za.bbd.ars.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private FlightRepository flightRepository;
    private TicketService ticketService;

    @Autowired
    public FlightServiceImpl(
            FlightRepository flightRepository,
            TicketService ticketService
    ) {
        this.flightRepository = flightRepository;
        this.ticketService = ticketService;
    }

    @Override
    public void deleteById(Integer id) {
        this.flightRepository.deleteById(id);
    }

    @Override
    public List<Flight> findAll() {
        return this.flightRepository.findAll();
    }


    @Override
    public Flight save(Flight flight) {
        return this.flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> read(Integer flightId) {
        return this.flightRepository.findById(flightId);
    }

    @Override
    public void delete(Flight flight) {
        this.flightRepository.delete(flight);
    }

    @Override
    public FlightDataResponse createNewFlightPlan(FlightData flightData) {
        Flight newFlight = flightData.getFlightObject();
        Flight savedFlight = this.save(newFlight);
        List<Ticket> newTickets = flightData.getTickets()
                .stream().map(flightTicketData ->
                        this.createTickets(flightTicketData, savedFlight.getFlightId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new FlightDataResponse(
                savedFlight,
                newTickets
        );
    }


    private List<Ticket> createTickets(FlightTicketData flightTicketData, Integer flightId){
        return flightTicketData.getSeats().stream().map(seatNUmber -> {
            Ticket newTicket = new Ticket(
                    0,
                    flightId,
                    0,
                    flightTicketData.getTicketDescription(),
                    flightTicketData.getPrice(),
                    seatNUmber
            );
            return ticketService.save(newTicket);
        }).collect(Collectors.toList());
    }

    @Override
    public List<FlightDataResponse> getFlights(FlightFilters filters) {

        return flightRepository.findAll().stream()
                .filter(flight -> Objects.equals(filters.getAirlineId(), flight.getAirlineId())
                        && Objects.equals(filters.getArrivalAirportId(), flight.getArrivalAirportId())
                        && Objects.equals(filters.getDepartureAirportId(), flight.getDepartureAirportId()))
                .map(filteredFlight -> {
                    List<Ticket> tickets = ticketService.findAllByFlightId(filteredFlight.getFlightId())
                            .stream().filter(ticket -> ticket.getPrice() >= filters.getMinPrice() && ticket.getPrice() <= filters.getMaxPrice())
                            .collect(Collectors.toList());
                    return new FlightDataResponse(filteredFlight, tickets);
                })
                .collect(Collectors.toList());
    }




}
