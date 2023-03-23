package co.za.bbd.ars.service;

import co.za.bbd.ars.model.Ticket;

import java.util.List;

public interface TicketService extends IService<Ticket, Integer>{
    void deleteById(Integer id);
    List<Ticket> findAll();
    List<Ticket> findAllByFlightId(Integer id);
}
