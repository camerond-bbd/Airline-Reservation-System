package co.za.bbd.ars.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import co.za.ars.model.Airport;
import co.za.ars.model.Reservation;
import co.za.ars.repository.ReservationRepository;


@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public Reservation createReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	@Override
	public List<Reservation> getAllReservations(){
		return reservationRepository.findAll();
	}
	
	@Override
	public Optional<Reservation> getReservationById(int reservationId) {
		return reservationRepository.findById(reservationId);
	}

	@Override
	public void deleteReservation(int reservationId) {
		Optional<Reservation> deleteReservation = reservationRepository.findById(reservationId);
		 reservationRepository.delete(deleteReservation.get());
	}

	@Override
	public Reservation updateReservation(Reservation reservation, int reservationId) {
		
		Optional<Reservation> reservationOptional = reservationRepository.findById(reservationId);
		
		Reservation updateReservation = reservationOptional.get();
		updateReservation.setFlight(reservation.getFlight());
		updateReservation.setPassenger(reservation.getPassenger());
		updateReservation.setReservationId(reservation.getReservationId());
		updateReservation.setTicket(reservation.getTicket());
		updateReservation.setReservationDate(reservation.getReservationDate());
		
		return reservationRepository.save(updateReservation);
	}
	
	
}
	
	
