package co.za.bbd.ars.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;


//TODO: Add the relationship annotation once Models are created


@Entity
@Data
@AllArgsConstructor
public class Ticket {
    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;
//    @ManyToOne
//    @JoinColumn(name = "FK_flightId", referencedColumnName = "flightId")
    @NotNull
    private int flightId;
//    @OneToOne
//    @JoinColumn(name = "FK_statusId", referencedColumnName = "statusId")
    @NotNull
    private int statusId;
    @NotNull
    private String ticketDescription;
    @NotNull
    private double price;
    @NotNull
    private int seatNumber;

    public Ticket() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId && flightId == ticket.flightId && statusId == ticket.statusId && price == ticket.price && seatNumber == ticket.seatNumber && Objects.equals(ticketDescription, ticket.ticketDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, flightId, statusId, ticketDescription, price, seatNumber);
    }
}
