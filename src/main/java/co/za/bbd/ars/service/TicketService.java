package co.za.bbd.ars.service;

import co.za.bbd.ars.model.Ticket;

import java.util.List;

public interface TicketService extends IService<Ticket, Integer>{
    void deleteById(Integer id);
    List<Ticket> findAll();
    List<Ticket> findAllByFlightId(Integer id);
//    List<Ticket> findAllByFlightIdAndPriceGreaterThenEqual(Integer flightId, double minPrice);
//    List<Ticket> findAllByFlightIdAndPriceLessThenEqual(Integer flightId, double maxPrice);
//    List<Ticket> findAllByFlightIdAndPriceLessThenEqualAndPriceGreaterThenEqual(Integer flightId, double maxPrice, double minPrice);
}
