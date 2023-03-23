package co.za.bbd.ars.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Reservation {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationId", nullable = false)
	private int reservationId;

	@ManyToOne
    @JoinColumn(name="flight_id")
	@Autowired
	private Flight flight;
	
	@ManyToOne
    @JoinColumn(name="ticket_id")
	@Autowired
	private Ticket ticket;
	
	@ManyToOne
    @JoinColumn(name="passenger_id")
	@Autowired
	private Passenger passenger;
	
	@NotNull
	@Column(name = "reservationDate", nullable = false)
	private Date reservationDate;
	
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}


	public Reservation(int reservationId, Flight flight, Ticket ticket, Passenger passenger,
			@NotNull Date reservationDate) {
		super();
		this.reservationId = reservationId;
		this.flight = flight;
		this.ticket = ticket;
		this.passenger = passenger;
		this.reservationDate = reservationDate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(flight, passenger, reservationDate, reservationId, ticket);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		return Objects.equals(flight, other.flight) && Objects.equals(passenger, other.passenger)
				&& Objects.equals(reservationDate, other.reservationDate) && reservationId == other.reservationId
				&& Objects.equals(ticket, other.ticket);
	}


	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", flight=" + flight + ", ticket=" + ticket
				+ ", passenger=" + passenger + ", reservationDate=" + reservationDate + "]";
	}


}
