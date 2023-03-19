package co.za.bbd.ars.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Entity
@Getter @Setter
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flightId", nullable = false)
    private Integer flightId;

    @Column(name = "airlineId", nullable = false)
    private Integer airlineId;

    @Column(name = "departureAirportId", nullable = false)
    private Integer departureAirportId;

    @Column(name = "arrivalAirportId", nullable = false)
    private Integer arrivalAirportId;

    @Column(name = "departureDate", nullable = false)
    private Date departureDate;

    @Column(name = "arrivalDate", nullable = false)
    private Date arrivalDate;

    @Column(name = "availableSeats", nullable = false)
    private Integer availableSeats;

    public Flight(Integer flightId, Integer airlineId, Integer departureAirportId, Integer arrivalAirportId, Date departureDate, Date arrivalDate, Integer availableSeats) {
        this.flightId = flightId;
        this.airlineId = airlineId;
        this.departureAirportId = departureAirportId;
        this.arrivalAirportId = arrivalAirportId;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.availableSeats = availableSeats;
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
                '}';
    }
}
