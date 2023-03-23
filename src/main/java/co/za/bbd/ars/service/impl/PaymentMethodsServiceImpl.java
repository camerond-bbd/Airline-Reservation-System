package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.PaymentMethods;
import co.za.bbd.ars.repository.PaymentMethodsRepository;
import co.za.bbd.ars.repository.TicketRepository;
import co.za.bbd.ars.service.PaymentMethodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodsServiceImpl implements PaymentMethodsService {
    private PaymentMethodsRepository repository;

    @Autowired
    public PaymentMethodsServiceImpl(PaymentMethodsRepository repository) {
        this.repository = repository;
    }
    @Override
    public PaymentMethods updatePaymentMethods(Integer paymentMethodId, PaymentMethods paymentMethods) {
        return null;
    }
    public PaymentMethods save(PaymentMethods paymentMethods) {
        return this.repository.save(paymentMethods);
    }
}
