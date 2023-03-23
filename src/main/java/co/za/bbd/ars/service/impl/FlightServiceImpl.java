package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.dtos.FlightData;
import co.za.bbd.ars.dtos.FlightDataResponse;
import co.za.bbd.ars.dtos.FlightFilters;
import co.za.bbd.ars.dtos.FlightTicketData;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.model.TicketStatuses;
import co.za.bbd.ars.repository.FlightRepository;
import co.za.bbd.ars.service.FlightService;
import co.za.bbd.ars.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final TicketServiceImpl ticketService;
    private final TicketStatusesImpl ticketStatuses;

    @Autowired
    public FlightServiceImpl(
            FlightRepository flightRepository,
            TicketServiceImpl ticketService,
            TicketStatusesImpl ticketStatuses
    ) {
        this.flightRepository = flightRepository;
        this.ticketService = ticketService;
        this.ticketStatuses = ticketStatuses;
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
                        this.createTickets(flightTicketData, savedFlight))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new FlightDataResponse(
                savedFlight,
                newTickets
        );
    }


    private List<Ticket> createTickets(FlightTicketData flightTicketData, Flight flight){
        return flightTicketData.getSeats().stream().map(seatNumber -> {
            TicketStatuses status = ticketStatuses.findStatusByStatusName(flightTicketData.getStatus());
            Ticket newTicket = new Ticket(
                    0,
                    flight,
                    status,
                    flightTicketData.getTicketDescription(),
                    flightTicketData.getPrice(),
                    seatNumber
            );
            System.out.println(newTicket);
            return ticketService.save(newTicket);
        }).collect(Collectors.toList());
    }

    @Override
    public List<FlightDataResponse> getFlights(FlightFilters filters) {

        return this.getFlightsByFilters(filters).stream()
                .map(filteredFlight -> {
                    List<Ticket> tickets = ticketService.findAllTicketsByFlightId(filteredFlight.getFlightId());
                    return new FlightDataResponse(filteredFlight, tickets);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightsByFilters(FlightFilters filters) {
        if (filters.getAirlineId() != null && filters.getArrivalAirportId() != null && filters.getDepartureAirportId() != null) {
            return flightRepository.findAllByAirlineIdAndDepartureAirportIdAndArrivalAirportId(filters.getAirlineId(), filters.getDepartureAirportId(), filters.getArrivalAirportId());
        } else if (filters.getAirlineId() != null && filters.getArrivalAirportId() == null && filters.getDepartureAirportId() == null) {
            return flightRepository.findAllByAirlineId(filters.getAirlineId());
        } else if (filters.getAirlineId() == null && filters.getArrivalAirportId() != null && filters.getDepartureAirportId() != null) {
            return flightRepository.findAllByDepartureAirportIdAndArrivalAirportId(filters.getDepartureAirportId(), filters.getArrivalAirportId());
        } else if (filters.getAirlineId() == null && filters.getArrivalAirportId() == null && filters.getDepartureAirportId() != null) {
            return flightRepository.findAllByDepartureAirportId(filters.getDepartureAirportId());
        } else if (filters.getAirlineId() == null && filters.getArrivalAirportId() != null) {
            return flightRepository.findAllByArrivalAirportId(filters.getArrivalAirportId());
        } else if (filters.getAirlineId() != null && filters.getArrivalAirportId() != null) {
            return  flightRepository.findAllByAirlineIdAndArrivalAirportId(filters.getAirlineId(), filters.getArrivalAirportId());
        } else if (filters.getAirlineId() != null) {
            return flightRepository.findAllByAirlineIdAndDepartureAirportId(filters.getAirlineId(), filters.getDepartureAirportId());
        }
        return this.findAll();
    }

    @Override
    public Flight updateFlight(Integer flightId, Flight flight) {
        if(!Objects.equals(flightId, flight.getFlightId())) {
            throw new IllegalArgumentException("Flight Id does not match param id");
        }
        return this.save(flight);
    }

}
