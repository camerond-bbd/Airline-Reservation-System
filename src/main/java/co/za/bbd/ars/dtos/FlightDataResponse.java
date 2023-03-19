package co.za.bbd.ars.dtos;

import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FlightDataResponse {
    private Flight flight;
    private List<Ticket> tickets;
}
