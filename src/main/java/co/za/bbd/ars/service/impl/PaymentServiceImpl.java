package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.repository.PaymentRepository;
import co.za.bbd.ars.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    private PaymentRepository repository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment save(Payment payment) {
        return this.repository.save(payment);
    }

    @Override
    public Optional<Payment> read(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Payment payment) {
        this.repository.delete(payment);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Payment> findAll() {
        return this.repository.findAll();
    }


}

