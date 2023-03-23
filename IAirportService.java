package co.za.ars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.ars.model.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {

}
