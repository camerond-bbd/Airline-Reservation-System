package co.za.bbd.ars.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class FlightFilters {
    private Integer airlineId;
    private Integer departureAirportId;
    private Integer arrivalAirportId;
}
