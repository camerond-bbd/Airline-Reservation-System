package co.za.bbd.ars.controller;

import co.za.bbd.ars.factory.PaymentFactory;
import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.*;
import co.za.bbd.ars.service.ReservationServiceImpl;
import co.za.bbd.ars.service.impl.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private PaymentController controller;
    @Autowired
    private ReservationServiceImpl reservationService;
    @Autowired
    private PaymentMethodsServiceImpl paymentMethodsService;
    @Autowired
    private FlightServiceImpl flightService;
    @Autowired
    private TicketServiceImpl ticketService;
    @Autowired
    private PassengerServiceImpl passengerService;
    @Autowired
    private TicketStatusesImpl statusService;
    @Autowired private TestRestTemplate restTemplate;

    private Payment payment;
    private Reservation reservation;
    private PaymentMethods methods;
    private Flight flight;
    private Ticket ticket;
    private TicketStatuses status;
    private Passenger passenger;
    private String baseURL;
    @BeforeEach
    void setUp() {
        assertNotNull(controller);
        mockValues();
        this.payment = PaymentFactory.createPayment(1, reservation, methods, 200.00, new Date("12 March 2023") );
        this.baseURL = "http://localhost:" + this.port + "/api/v1/airline-system/payment/";
    }

    @Test
    @Order(1)
    void save() {
        String url = baseURL + "save";
        ResponseEntity<Payment> response = this.restTemplate.postForEntity(url, this.payment, Payment.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(2)
    void read() {
        String url = baseURL + "read/" + this.payment.getPaymentId();
        ResponseEntity<Payment> response = this.restTemplate.getForEntity(url, Payment.class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertNotNull(response.getBody())
        );
    }

    @Test @Order(3)
    void deleteById() {
        String url = baseURL + "delete/" + this.payment.getPaymentId();
        this.restTemplate.delete(url);
    }

    @Test @Order(4)
    void findAll() {
        String url = baseURL + "all";
        ResponseEntity<Payment[]> response = this.restTemplate.getForEntity(url, Payment[].class);
        assertAll(
                () -> assertEquals(HttpStatus.OK, response.getStatusCode()),
                () -> assertTrue(response.getBody().length == 0)
        );
    }

    private void mockValues() {
        this.flight = new Flight(1, 1, 1, 1, new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), 10);
        this.flightService.save(flight);

        this.status = new TicketStatuses(1, "PENDING");
        this.statusService.save(status);

        this.ticket = TicketFactory.createTicket(1, flight, status, "test-description", 200.00, 1);
        this.ticketService.save(this.ticket);

        this.passenger = new Passenger(1, "test-name", "second-name", "test@gmail.com", "0825101207", new Date(), "ZA");
        this.passengerService.save(passenger);

        this.reservation = new Reservation(1, flight, ticket, passenger, new Date("12 March 2023") );
        this.reservationService.createReservation(reservation);

        this.methods = new PaymentMethods(1, "Paypal");
        this.paymentMethodsService.save(methods);
    }
}