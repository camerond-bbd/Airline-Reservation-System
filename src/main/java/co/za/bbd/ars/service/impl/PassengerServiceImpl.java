package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.dtos.PassengerFilters;
import co.za.bbd.ars.model.Passenger;
import co.za.bbd.ars.repository.PassengerRepository;
import co.za.bbd.ars.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.databind.type.LogicalType.Collection;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger save(Passenger passenger) {
        return this.passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> read(Integer passengerId) {
        return this.passengerRepository.findById(passengerId);
    }

    @Override
    public void delete(Passenger passenger) {
        this.passengerRepository.delete(passenger);
    }

//    @Override
    public Passenger createNewPassenger(Passenger passengerData) {
        return this.save(passengerData);
    }

//    @Override
    public List<Passenger> getPassengers(PassengerFilters filters) {
        return getPassengersByFilters(filters);
    }


    private List<Passenger> getPassengersByFilters(PassengerFilters passengerFilters) {
        Integer passengerId = passengerFilters.getPassengerId();
        String firstName = passengerFilters.getFirstName();
        String lastName = passengerFilters.getLastName();
        String email = passengerFilters.getEmail();
        String phoneNumber = passengerFilters.getPhoneNumber();
        Date dateOfBirth = passengerFilters.getDateOfBirth();
        String nationality = passengerFilters.getNationality();

        if(passengerId != null) {
            return passengerRepository.findByPassengerId(passengerId);
        } else {
            if (firstName != null && lastName != null && email != null && phoneNumber != null && dateOfBirth != null && nationality != null){
                return passengerRepository.findAllByFirstNameAndLastNameAndEmailAndPhoneNumberAndDateOfBirthAndNationality(firstName, lastName, email, phoneNumber, dateOfBirth, nationality);
            } else if (firstName != null && lastName != null && email != null && phoneNumber != null && dateOfBirth != null && nationality == null) {
                return passengerRepository.findAllByFirstNameAndLastNameAndEmailAndPhoneNumberAndDateOfBirth(firstName, lastName, email, phoneNumber, dateOfBirth);
            } else if (firstName != null && lastName != null && email != null && phoneNumber != null && dateOfBirth == null && nationality == null) {
                return passengerRepository.findAllByFirstNameAndLastNameAndEmailAndPhoneNumber(firstName, lastName, email, phoneNumber);
            }else if (firstName != null && lastName != null && email != null && phoneNumber == null && dateOfBirth == null && nationality == null) {
                return passengerRepository.findAllByFirstNameAndLastNameAndEmail(firstName, lastName, email);
            }else if (firstName != null && lastName != null && email == null && phoneNumber == null && dateOfBirth == null && nationality == null) {
                return passengerRepository.findAllByFirstNameAndLastName(firstName, lastName);
            }else if (firstName != null && lastName == null && email == null && phoneNumber == null && dateOfBirth == null && nationality == null) {
                return passengerRepository.findAllByFirstName(firstName);
            }
            return this.passengerRepository.findAll();
        }
    }

    @Override
    public Passenger updatePassenger(Integer passengerId, Passenger passenger) {
        if(!Objects.equals(passengerId, passenger.getPassengerId())) {
            throw new IllegalArgumentException("Passenger Id does not match param id");
        }
        return this.save(passenger);
    }
}
