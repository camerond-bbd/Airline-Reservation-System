package co.za.bbd.ars.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class FlightTicketData {

    private String status;
    private String ticketDescription;
    private double price;
    private List<Integer> seats;
}
