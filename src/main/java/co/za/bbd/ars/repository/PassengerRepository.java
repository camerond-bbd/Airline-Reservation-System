package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findAllByPassengerId(Integer Id);
    List<Passenger> findAllByName(String firstName, String lastName);
    List<Passenger> findAllByDateOfBirth(Date dateOfBirth);
}
