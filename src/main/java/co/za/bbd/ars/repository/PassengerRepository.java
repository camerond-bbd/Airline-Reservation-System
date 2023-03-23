package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    List<Passenger> findByPassengerId(Integer Id);
    List<Passenger> findAllByPassengerId(Integer passengerId);
    List<Passenger> findAllByFirstNameAndLastNameAndEmailAndPhoneNumberAndDateOfBirthAndNationality(String firstName,String lastName,String email, String phoneNumber, Date dateOfBirth, String nationality);
    List<Passenger> findAllByFirstNameAndLastNameAndEmailAndPhoneNumberAndDateOfBirth(String firstName,String lastName,String email, String phoneNumber, Date dateOfBirth);
    List<Passenger> findAllByFirstNameAndLastNameAndEmailAndPhoneNumber(String firstName,String lastName,String email, String phoneNumber);
    List<Passenger> findAllByFirstNameAndLastNameAndEmail(String firstName,String lastName,String email);
    List<Passenger> findAllByFirstNameAndLastName(String firstName,String lastName);
    List<Passenger> findAllByFirstName(String firstName);
    List<Passenger> findAllByLastName(String lastName);
    List<Passenger> findAllByDateOfBirth(Date dateOfBirth);
}
