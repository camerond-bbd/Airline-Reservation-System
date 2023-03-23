package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.model.TicketStatuses;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketServiceImplTest {
    private Ticket ticket;
    private Flight flight;
    private TicketStatuses status;
    @Autowired
    private TicketServiceImpl service;
    @Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private TicketStatusesImpl statusService;

    @BeforeEach
    void setUp() {
        mockValues();
        this.ticket = TicketFactory.createTicket(1, flight, status, "test-description", 200.00, 1);
    }
    @Test
    @Order(1)
    void save() {
        Ticket saved = this.service.save(this.ticket);
        assertEquals(this.ticket, saved);
    }
    @Test
    @Order(2)
    void read() {
        Optional<Ticket> read = this.service.read(ticket.getTicketId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(ticket, read.get())
        );
    }

    @Test
    @Order(3)
    void findAll() {
        List<Ticket> tickets = this.service.findAll();
        assertEquals(1, tickets.size());
    }

    @Test
    @Order(4)
    void deleteById() {
        this.service.deleteById(ticket.getTicketId());
        List<Ticket> tickets = this.service.findAll();
        assertAll(
                () -> assertEquals(0, tickets.size())
        );
    }

    private void mockValues() {
        this.flight = new Flight(1, 1, 1, 1, new Date("12 March 2023"), new Date("12 March 2023"), 10);
        this.flightService.save(flight);
        this.status = new TicketStatuses(1, "PENDING");
        this.statusService.save(status);
    }
}