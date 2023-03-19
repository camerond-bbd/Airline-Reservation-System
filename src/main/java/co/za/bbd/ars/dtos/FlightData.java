package co.za.bbd.ars.dtos;

import co.za.bbd.ars.model.Flight;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class FlightData {
    private Integer arlineId;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private Date departureDate;
    private Date arrivalDate;
    private Integer availableSeats;
    private List<FlightTicketData> tickets;

    public Flight getFlightObject() {
        return new Flight(
                null,
                this.arlineId,
                this.departureAirportId,
                this.arrivalAirportId,
                this.departureDate,
                this.arrivalDate,
                this.availableSeats
        );
    }
}
