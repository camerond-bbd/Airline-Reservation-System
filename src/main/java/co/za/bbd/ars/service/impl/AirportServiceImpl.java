package co.za.ars.service;
import co.za.ars.model.Airport;
import co.za.ars.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl  implements AirportService{
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
	
}
