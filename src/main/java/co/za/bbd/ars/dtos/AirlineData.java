package co.za.bbd.ars.dtos;

import co.za.bbd.ars.model.Airline;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class AirlineData {
    private String airlineName;

    public Airline getAirlineObject() {
        return new Airline(
                null,
                this.airlineName
        );
    }
}
