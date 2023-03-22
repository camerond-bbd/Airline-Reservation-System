package co.za.bbd.ars.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Objects;


//TODO: Add the relationship annotation once Models are created
@Entity
@Data
public class Ticket {
    @NotNull
    @Id
    private int ticketId;
    @NotNull
    private int flightId;
    @NotNull
    private int statusId;
    @NotNull
    private String ticketDescription;
    @NotNull
    private double price;
    @NotNull
    private int seatNumber;

    public Ticket(int ticketId, int flightId, int statusId, String ticketDescription, double price, int seatNumber) {
        this.ticketId = ticketId;
        this.flightId = flightId;
        this.statusId = statusId;
        this.ticketDescription = ticketDescription;
        this.price = price;
        this.seatNumber = seatNumber;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketId == ticket.ticketId && flightId == ticket.flightId && statusId == ticket.statusId && Double.compare(ticket.price, price) == 0 && seatNumber == ticket.seatNumber && Objects.equals(ticketDescription, ticket.ticketDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, flightId, statusId, ticketDescription, price, seatNumber);
    }
}
