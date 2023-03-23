package co.za.bbd.ars.api;

import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.service.impl.FlightServiceImpl;
import co.za.bbd.ars.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TicketAPI {
    private TicketServiceImpl ticketService;
    private FlightServiceImpl flightService;

    @Autowired
    public TicketAPI(TicketServiceImpl ticketService, FlightServiceImpl flightService) {
        this.ticketService = ticketService;
        this.flightService = flightService;
    }

    public Ticket save(Ticket ticket) {
        this.flightService.read(ticket.getFlight().getFlightId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found"));

        return this.ticketService.save(ticket);
    }
}
