package co.za.bbd.ars.controller;

import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.*;
import co.za.bbd.ars.service.FlightService;
import co.za.bbd.ars.service.ReservationServiceImpl;
import co.za.bbd.ars.service.TicketStatusesService;
import co.za.bbd.ars.service.impl.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TicketControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TicketController controller;
    @Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private PaymentMethodsServiceImpl paymentMethodsService;
    @Autowired
    private TicketStatusesImpl statusService;
    @Autowired private TestRestTemplate restTemplate;

    private Ticket ticket;
    private Flight flight;
    private TicketStatuses status;
    private String baseURL;
    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        mockValues();
        this.ticket = TicketFactory.createTicket(1, flight, status, "test-description", 200.00, 1);
        this.baseURL = "http://localhost:" + this.port + "/api/v1/airline-system/ticket/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Ticket> response = this.restTemplate.postForEntity(url, this.ticket, Ticket.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(2)
    void read() {
        String url = baseURL + "read/" + this.ticket.getTicketId();
        ResponseEntity<Ticket> response = this.restTemplate.getForEntity(url, Ticket.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.ticket.getTicketId();
        this.restTemplate.delete(url);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<Ticket[]> response = this.restTemplate.getForEntity(url, Ticket[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }

    private void mockValues() {
        this.flight = new Flight(1, 1, 1, 1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 10);
        this.flightService.save(flight);
        this.status = new TicketStatuses(1, "PENDING");
        this.statusService.save(status);
    }
}