package co.za.bbd.ars.service;
import co.za.bbd.ars.model.Airport;

import java.util.List;
import java.util.Optional;
public interface AirportService extends IService {
	
    List<Airport> getAllAirports();
    
    Optional<Airport> getAirportById(int id) throws ClassNotFoundException;
    
    Airport createAirport(Airport airport);
    
    void deleteAirportById(int id);
    
    Airport updateAirportById(int id, Airport airport);
}
