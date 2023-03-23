package co.za.bbd.ars.service;

import java.util.List;
import java.util.Optional;

import co.za.ars.model.Reservation;

public interface ReservationService {
	
	Reservation createReservation(Reservation reservation);
	
	List<Reservation> getAllReservations();
	
	Optional<Reservation> getReservationById(int reservationId);
	
	void deleteReservation(int reservationId);
	
	Reservation updateReservation(Reservation reservation, int reservationId);

}
