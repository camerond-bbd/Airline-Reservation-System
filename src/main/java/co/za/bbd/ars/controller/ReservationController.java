package co.za.ars.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.za.ars.model.Reservation;
import co.za.ars.repository.ReservationRepository;
import co.za.ars.service.ReservationService;


@RestController
@RequestMapping("api/v1/airline-system/ticket")
public class ReservationController {
	
	@Autowired
	private ReservationService reservationService;
	
	@PostMapping()
	public ResponseEntity<Reservation> saveReservation(@RequestBody Reservation reservation){
		
		Reservation saveReservation = reservationService.createReservation(reservation);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(saveReservation);
		
	}
	
	@GetMapping()
	public ResponseEntity<List<Reservation>> getAllReservations(){
		
		List<Reservation> reservations  = reservationService.getAllReservations();
		
		return ResponseEntity.status(HttpStatus.OK).body(reservations);
		
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Reservation> getReservationById(@PathVariable int id){
		
		Reservation reservation = reservationService.getReservationById(id).get();
		
		return ResponseEntity.status(HttpStatus.OK).body(reservation);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Reservation> updateReservationById(@RequestBody Reservation reservation,@PathVariable int id){
		reservationService.updateReservation(reservation, id);
		return ResponseEntity.status(HttpStatus.OK).body(reservation);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Reservation> deleteReservationById(@PathVariable int id){
		Reservation reservation = reservationService.getReservationById(id).get();
		reservationService.deleteReservation(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(reservation);
		
	}

}
