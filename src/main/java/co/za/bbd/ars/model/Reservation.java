package co.za.bbd.ars.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter

public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reservationId", nullable = false)
	private int reservationId;

	@ManyToOne
        @JoinColumn(name="flightId")
	@Autowired
	private Flight flight;
	
	@OneToOne
        @JoinColumn(name="ticketId")
	@Autowired
	private Ticket ticket;
	
	@ManyToOne
        @JoinColumn(name="passengerId")
	@Autowired
	private Passenger passenger;
	
	@NotNull
	@Column(name = "reservationDate", nullable = false)
	private Date reservationDate;

	public Reservation() {
	}

	public Reservation(int reservationId, Flight flight, Ticket ticket, Passenger passenger, Date reservationDate) {
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
