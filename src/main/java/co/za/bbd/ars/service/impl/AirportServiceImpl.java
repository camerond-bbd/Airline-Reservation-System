package co.za.bbd.ars.service.impl;

import co.za.bbd.ars.model.Airport;
import co.za.bbd.ars.repository.AirportRepository;
import co.za.bbd.ars.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl  implements AirportService {
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }
    public Optional<Airport> getAirportById(int id) {
        return airportRepository.findById(id);
    }
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }
    public void deleteAirportById(int id) {
        airportRepository.deleteById(id);
    }

    @Override
    public Airport updateAirportById(int id, Airport airport) {
        return null;
    }

    public Airport updateAirport(int id, Airport airport) throws Exception {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isEmpty()) {
            throw new Exception("Airport not found");
        }
        Airport existingAirport = airportOptional.get();
        existingAirport.setAirName(airport.getAirName());
        existingAirport.setCity(airport.getCity());
        existingAirport.setCountry(airport.getCountry());
       
        return airportRepository.save(existingAirport);
    }

    @Override
    public Object save(Object o) {
        return null;
    }

    @Override
    public Optional read(Object o) {
        return Optional.empty();
    }

    @Override
    public void delete(Object o) {

    }
}
