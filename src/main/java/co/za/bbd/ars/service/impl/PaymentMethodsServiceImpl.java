package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.PaymentMethods;
import co.za.bbd.ars.repository.PaymentMethodsRepository;
import co.za.bbd.ars.repository.TicketRepository;
import co.za.bbd.ars.service.PaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class PaymentMethodsServiceImpl implements PaymentMethodsService {

    private final PaymentMethodsRepository repository;

    @Autowired
    public PaymentMethodsServiceImpl(PaymentMethodsRepository repository) {
        this.repository = repository;
    }

    @Override
    public PaymentMethods updatePaymentMethods(Integer paymentMethodId, PaymentMethods paymentMethods) {
        if(!Objects.equals(paymentMethodId, paymentMethods.getPaymentMethodId())) {
            throw new IllegalArgumentException("PaymentMethods Id does not match param id");
        }
        return this.save(paymentMethods);
    }

    @Override
    public PaymentMethods save(PaymentMethods paymentMethods) {
        return repository.save(paymentMethods);
    }

    @Override
    public Optional<PaymentMethods> read(Integer integer) {
        return Optional.empty();
    }

    @Override
    public void delete(PaymentMethods paymentMethods) {

    }
    public PaymentMethods save(PaymentMethods paymentMethods) {
        return this.repository.save(paymentMethods);
    }
}
