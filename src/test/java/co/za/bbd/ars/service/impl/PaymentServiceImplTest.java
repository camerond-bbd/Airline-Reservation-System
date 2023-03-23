package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.factory.PaymentFactory;
import co.za.bbd.ars.factory.TicketFactory;
import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.model.Ticket;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PaymentServiceImplTest {
    private Payment payment;
    @Autowired
    private PaymentServiceImpl service;

    @BeforeEach
    void setUp() {
        this.payment = PaymentFactory.createPayment(1, 1, 1,  200.00, new Date(System.currentTimeMillis()));
        this.service.save(this.payment);
    }

    @Test
    @Order(1)
    void save() {
        Payment saved = this.service.save(this.payment);
        assertEquals(this.payment, saved);
    }

    @Test
    @Order(2)
    void read() {
        Optional<Payment> read = this.service.read(payment.getPaymentId());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () -> assertEquals(payment, read.get())
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
}