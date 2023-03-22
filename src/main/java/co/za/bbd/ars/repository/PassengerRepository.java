package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findAllByPassengerId(Integer Id);
    List<Passenger> findAllByFirstNameAndLastName(String firstName, String lastName);
    List<Passenger> findAllByDateOfBirth(Date dateOfBirth);
}
