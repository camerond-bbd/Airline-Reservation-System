package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.Passenger;
import co.za.bbd.ars.repository.PassengerRepository;
import co.za.bbd.ars.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

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

    /*@Override
    public PassengerDataResponse createNewPassenger(PassengerData passengerData) {
        Passenger newPassenger = passengerData.getPassengerObject();
        Passenger savedPassenger = this.save(newPassenger);
        List<Passenger> newPassengers = passengerData.getPassengers()
                .stream().map(flightTicketData ->
                        this.createPassengers(flightTicketData, savedPassenger.getPassengerId()))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return new FlightDataResponse(
                savedFlight,
                newTickets
        );
    }

    @Override
    public List<PassengerDataResponse> getPassengers(PassengerFilters filters) {
        return this.getPassengersByFilter(filters).stream()
                .map(filteredPassengers -> {
                    List<Ticket> tickets = this.getTicketsByFilters(filteredFlight.getFlightId(), filters);
                    return new FlightDataResponse(filteredFlight, tickets);
                })
                .collect(Collectors.toList());
    }*/

    @Override
    public Passenger updatePassenger(Integer passengerId, Passenger passenger) {
        if(!Objects.equals(passengerId, passenger.getPassengerId())) {
            throw new IllegalArgumentException("Passenger Id does not match param id");
        }
        return this.save(passenger);
    }
}
