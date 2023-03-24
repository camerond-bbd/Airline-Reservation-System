package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.controller.PaymentController;
import co.za.bbd.ars.factory.PaymentFactory;
import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.*;
import co.za.bbd.ars.service.ReservationServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceImplTest {
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
    private Payment payment;
    private Reservation reservation;
    private PaymentMethods methods;
    private Flight flight;
    private Ticket ticket;
    private TicketStatuses status;
    private Passenger passenger;
    @Autowired
    private PaymentServiceImpl service;

    @BeforeEach
    void setUp() {
        mockValues();
        this.payment = PaymentFactory.createPayment(1, reservation, methods,  200.00, new Date());
    }

    @Test
    @Order(1)
    void save() {
        Payment saved = this.service.save(this.payment);
        assertNotNull(saved);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Payment> read = this.service.read(payment.getPaymentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertNotNull(read.get())
        );
    }

    @Test
    @Order(3)
    void findAll() {
        List<Payment> payments = this.service.findAll();
        assertEquals(1, payments.size());
    }

    @Test
    @Order(4)
    void deleteById() {
        this.service.deleteById(payment.getPaymentId());
        List<Payment> payments = this.service.findAll();
        assertAll(
                () -> assertEquals(0, payments.size())
        );
    }

    private void mockValues() {
        this.flight = new Flight(1, 1, 1, 1, new java.sql.Date(System.currentTimeMillis()), new java.sql.Date(System.currentTimeMillis()), 10);
        this.flightService.save(flight);

        this.status = new TicketStatuses(1, "PENDING");
        this.statusService.save(status);

        this.ticket = TicketFactory.createTicket(1, flight, status, "test-description", 200.00, 1);
        this.ticketService.save(this.ticket);

        this.passenger = new Passenger(1, "test-name", "second-name", "test@gmail.com", "0825101207", new java.util.Date(), "ZA");
        this.passengerService.save(passenger);

        this.reservation = new Reservation(1, flight, ticket, passenger, new Date() );
        this.reservationService.createReservation(reservation);

        this.methods = new PaymentMethods(1, "Paypal");
        this.paymentMethodsService.save(new PaymentMethods(1, "Paypal"));
    }
}