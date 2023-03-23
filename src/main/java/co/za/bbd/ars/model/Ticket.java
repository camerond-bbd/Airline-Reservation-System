package co.za.bbd.ars.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Objects;


//TODO: Add the relationship annotation once Models are created


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ticket implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="flight_id")
    @NotNull
    private Flight flight;
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="status_id")
    @NotNull
    private TicketStatuses status;
    @NotNull
    private String ticketDescription;
    @NotNull
    private double price;
    @NotNull
    private int seatNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId && Double.compare(ticket.price, price) == 0 && seatNumber == ticket.seatNumber && flight.equals(ticket.flight) && status.equals(ticket.status) && ticketDescription.equals(ticket.ticketDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, flight, status, ticketDescription, price, seatNumber);
    }
}
