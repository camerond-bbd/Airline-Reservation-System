package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    List<Flight> findAllByDepartureAirportId(Integer departureAirportId);
    List<Flight> findAllByArrivalAirportId(Integer arrivalAirportId);
    List<Flight> findAllByDepartureAirportIdAndArrivalAirportId(Integer departureAirportId, Integer arrivalAirportId);

    List<Flight> findAllByAirlineId(Integer airlineId);
    List<Flight> findAllByAirlineIdAndDepartureAirportId(Integer airlineId, Integer departureAirportId);
    List<Flight> findAllByAirlineIdAndArrivalAirportId(Integer airlineId, Integer arrivalAirportId);
    List<Flight> findAllByAirlineIdAndDepartureAirportIdAndArrivalAirportId(Integer airlineId, Integer departureAirportId, Integer arrivalAirportId);

}
