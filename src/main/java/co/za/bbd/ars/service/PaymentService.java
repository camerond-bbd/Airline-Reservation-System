package co.za.bbd.ars.service;

import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.model.Ticket;

import java.util.List;

public interface PaymentService extends IService<Payment, Integer>{
    void deleteById(Integer id);
    List<Payment> findAll();
}
