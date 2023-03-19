package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.repository.TicketRepository;
import co.za.bbd.ars.service.IService;
import co.za.bbd.ars.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {
    private TicketRepository repository;

    @Autowired
    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ticket save(Ticket ticket) {
        return this.repository.save(ticket);
    }

    @Override
    public Optional<Ticket> read(Integer id) {
        return this.repository.findById(id);
    }

    @Override
    public void delete(Ticket ticket) {
        this.repository.delete(ticket);
    }

    @Override
    public void deleteById(Integer id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Ticket> findAll() {
        return this.repository.findAll();
    }

    public List<Ticket> findAllByFlightId(Integer id) {
        return repository.findAllByFlightId(id);
    }

    @Override
    public List<Ticket> findAllByFlightIdAndPriceGreaterThenEqual(Integer flightId, double minPrice) {
        return repository.findAllByFlightIdAndPriceGreaterThenEqual(flightId, minPrice);
    }

    @Override
    public List<Ticket> findAllByFlightIdAndPriceLessThenEqual(Integer flightId, double maxPrice) {
        return repository.findAllByFlightIdAndPriceLessThenEqual(flightId, maxPrice);
    }

    @Override
    public List<Ticket> findAllByFlightIdAndPriceLessThenEqualAndPriceGreaterThenEqual(Integer flightId, double maxPrice, double minPrice) {
        return repository.findAllByFlightIdAndPriceLessThenEqualAndPriceGreaterThenEqual(flightId, maxPrice, minPrice);
    }


}
