package co.za.ars.controller;

import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import co.za.ars.model.Airport;
import co.za.ars.repository.AirportRepository;
import co.za.ars.service.AirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	private static final Logger logger = LoggerFactory.getLogger(AirportController.class);
	 
	@GetMapping()
	public List<Airport> retrieveAllAirports(){
		return airportService.getAllAirports();
	}
	
	@GetMapping("/{id}")
	public EntityModel<Airport> retrieveAirport(@PathVariable int id) throws Exception{
		
		Optional<Airport> airport = airportService.getAirportById(id);
		if(!airport.isPresent()) 
			throw new NoSuchElementException(" Airport with id="+ id + " not found.");
		
		logger.info(airport.get().toString());
		
		EntityModel<Airport> resource = EntityModel.of(airport.get());
		WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllAirports());
		resource.add(linkTo.withRel("all-airports"));
		
		return resource;
	}
	
	@PostMapping()
	public ResponseEntity<Object> createAirport(@Valid @RequestBody Airport airport){
		 Airport savedAirport = airportService.createAirport(airport);
		 URI location = URI.create("/airports/" + savedAirport.getAirportId());
		 return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAirport(@Valid @RequestBody Airport airport,@PathVariable int id) throws Exception{
		Airport updatedAirport = airportService.updateAirport(id, airport);
		return ResponseEntity.noContent().build();
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object>  deleteAirport(@PathVariable int id) {
		Optional<Airport> airport = airportService.getAirportById(id);
		if(!airport.isPresent()) 
			throw new NoSuchElementException(" Airport with id="+ id + " not found.");
		airportService.deleteAirportById(id);
		
		return ResponseEntity.noContent().build();
		
	}
	

}
