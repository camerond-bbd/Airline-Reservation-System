package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.Airline;
import co.za.bbd.ars.repository.AirlineRepository;
import co.za.bbd.ars.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline save(Airline airline) {
        return this.airlineRepository.save(airline);
    }

    @Override
    public Optional<Airline> read(Integer airlineId) {
        return this.airlineRepository.findById(airlineId);
    }

    @Override
    public void delete(Airline airline) {
        this.airlineRepository.delete(airline);
    }

    @Override
    public Airline updateAirline(Integer airlineId, Airline airline) {
        if(!Objects.equals(airlineId, airline.getAirlineId())) {
            throw new IllegalArgumentException("Airline Id does not match param id");
        }
        return this.save(airline);
    }
}
