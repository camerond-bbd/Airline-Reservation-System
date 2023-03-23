package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
    List<Airline> findAllByAirlineName(String airlineName);
}
