package co.za.bbd.ars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.za.bbd.ars.model.Reservation;


@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{

	
}
