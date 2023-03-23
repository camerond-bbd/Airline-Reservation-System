package co.za.bbd.ars.factory;

import co.za.bbd.ars.helpers.StringHelper;
import co.za.bbd.ars.helpers.Validator;
import co.za.bbd.ars.model.Flight;
import co.za.bbd.ars.model.Ticket;
import co.za.bbd.ars.model.TicketStatuses;

public class TicketFactory {
    public static Ticket createTicket(int ticketId, Flight flight, TicketStatuses status, String ticketDescription, double price, int seatNumber) {
        StringHelper.checkStringParam("ticketDescription", ticketDescription);
        Validator.greaterThan(0, price);
        Validator.greaterThan(0, seatNumber);

        return new Ticket(ticketId, flight, status, ticketDescription, price, seatNumber);
    }
}
