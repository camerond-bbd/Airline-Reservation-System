package co.za.bbd.ars.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Data
@AllArgsConstructor

public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airlineId", nullable = false)
    private Integer airlineId;

    @Column(name = "airlineName", nullable = false)
    private String airlineName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        Airline airline = (Airline) o;
        return airlineId == airline.airlineId && airlineName == airline.airlineName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(airlineId, airlineName);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineId=" + airlineId +
                "airlineName=" + airlineName +
                "}";
    }
}
