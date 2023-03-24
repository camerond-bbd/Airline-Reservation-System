package co.za.bbd.ars.model;

import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
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
@Set
@AllArgsConstructor
@NoArgsConstructor

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
	
	@ManyToOne
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
