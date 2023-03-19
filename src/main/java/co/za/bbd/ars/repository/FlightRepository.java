package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
