package co.za.bbd.ars.controller;

import co.za.bbd.ars.dtos.PassengerFilters;
import co.za.bbd.ars.model.Passenger;
import co.za.bbd.ars.service.impl.PassengerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/airline-system/passenger")
public class PassengerController {
    private final PassengerServiceImpl passengerService;

    @Autowired
    public PassengerController(PassengerServiceImpl passengerService) {
        this.passengerService = passengerService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Passenger> createNewPassenger(@RequestBody Passenger passengerData)
    {
        Passenger newPassenger = passengerService.createNewPassenger(passengerData);
        return new ResponseEntity<>(newPassenger, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Passenger>> getAllPassengers(
            @RequestParam(value = "passengerId", required = false) Integer passengerId,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(value = "dateOfBirth", required = false) Date dateOfBirth,
            @RequestParam(value = "nationality", required = false) String nationality)
    {
        PassengerFilters filters = new PassengerFilters(passengerId, firstName, lastName, email, phoneNumber, dateOfBirth, nationality);
        List<Passenger> passengerDataResponses = passengerService.getPassengers(filters);
        return new ResponseEntity<>(passengerDataResponses, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{passenger}/update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity updatePassenger(
            @PathVariable Integer passengerId,
            @RequestBody Passenger passenger
    ) {
        try {
            Passenger updatedPassenger = passengerService.updatePassenger(passengerId, passenger);
            return new ResponseEntity<>(updatedPassenger, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
