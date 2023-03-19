package co.za.bbd.ars.service;

import co.za.bbd.ars.model.DummyDomain;
import co.za.bbd.ars.model.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService extends IService<Ticket, Integer>{
    void deleteById(Integer id);
    List<Ticket> findAll();
    List<Ticket> findByFlightId(Integer id);
}
