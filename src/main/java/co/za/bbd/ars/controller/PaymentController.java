package co.za.bbd.ars.controller;

import co.za.bbd.ars.factory.PaymentFactory;
import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/airline-system/payment")
public class PaymentController {
    private final PaymentServiceImpl paymentService;

    @Autowired
    public PaymentController(PaymentServiceImpl service) {
        this.paymentService = service;
    }

    @PostMapping("save")
    public ResponseEntity<Payment> save(@Valid @RequestBody Payment payment) {
        Payment savePayment = PaymentFactory.createPayment(payment.getPaymentId(), payment.getReservation(), payment.getPaymentMethod(), payment.getAmountPaid(), payment.getPaymentDate());
        return ResponseEntity.ok(paymentService.save(savePayment));
    }

    @GetMapping("read/{id}")
    public ResponseEntity<Payment> read(@PathVariable Integer id) {
        var payment = this.paymentService.read(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment Could Not Be Found"));
        return ResponseEntity.ok(payment);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Payment payment) {
        this.paymentService.delete(payment);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Integer id) {
        this.paymentService.deleteById(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("all")
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> paymentList = this.paymentService.findAll();
        return ResponseEntity.ok(paymentList);
    }
}