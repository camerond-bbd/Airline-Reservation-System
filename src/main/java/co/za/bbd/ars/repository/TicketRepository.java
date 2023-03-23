package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
    List<Ticket> findAllByFlightId(Integer flightId);
//    List<Ticket> findAllByFlightIdAndPriceGreaterThenEqual(Integer flightId, double minPrice);
//    List<Ticket> findAllByFlightIdAndPriceLessThenEqual(Integer flightId, double maxPrice);
//    List<Ticket> findAllByFlightIdAndPriceLessThenEqualAndPriceGreaterThenEqual(Integer flightId, double maxPrice, double minPrice);
}
