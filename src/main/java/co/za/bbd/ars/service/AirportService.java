package co.za.ars.service;
import co.za.ars.model.Airport;
import java.util.List;
import java.util.Optional;
public interface AirportService {
	
    List<Airport> getAllAirports();
    
    Optional<Airport> getAirportById(int id) throws ClassNotFoundException;
    
    Airport createAirport(Airport airport);
    
    void deleteAirportById(int id);
    
    void updateAirportById(Airport airport, int id);
}
