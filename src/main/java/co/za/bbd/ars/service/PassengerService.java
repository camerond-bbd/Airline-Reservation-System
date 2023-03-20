package co.za.bbd.ars.service;

import co.za.bbd.ars.model.Passenger;

public interface PassengerService extends IService<Passenger, Integer> {
    //PassengerDataResponse createNewPassenger(PassengerData passengerData);

    //List<PassengerDataResponse> getPassengers(PassengerFilters filters);

    Passenger updatePassenger(Integer passengerId, Passenger passenger);
}
