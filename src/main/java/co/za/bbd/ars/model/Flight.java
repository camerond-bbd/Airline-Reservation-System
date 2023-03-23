package co.za.bbd.ars.model;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor

public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId", nullable = false)
    private int flightId;

    @Column(name = "airlineId", nullable = false)
    private int airlineId;

    @Column(name = "departureAirportId", nullable = false)
    private int departureAirportId;

    @Column(name = "arrivalAirportId", nullable = false)
    private int arrivalAirportId;

    @Column(name = "departureDate", nullable = false)
    private Date departureDate;

    @Column(name = "arrivalDate", nullable = false)
    private Date arrivalDate;

    @Column(name = "availableSeats", nullable = false)
    private int availableSeats;

    public Flight() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && airlineId == flight.airlineId && departureAirportId == flight.departureAirportId && arrivalAirportId == flight.arrivalAirportId && availableSeats == flight.availableSeats && departureDate.equals(flight.departureDate) && arrivalDate.equals(flight.arrivalDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, airlineId, departureAirportId, arrivalAirportId, departureDate, arrivalDate, availableSeats);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", airlineId=" + airlineId +
                ", departureAirportId=" + departureAirportId +
                ", arrivalAirportId=" + arrivalAirportId +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", availableSeats=" + availableSeats +
                "}";
    }
}
