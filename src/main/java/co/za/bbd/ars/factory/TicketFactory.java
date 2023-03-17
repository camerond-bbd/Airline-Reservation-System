package co.za.bbd.ars.factory;

import co.za.bbd.ars.helpers.StringHelper;
import co.za.bbd.ars.helpers.Validator;
import co.za.bbd.ars.model.Ticket;

public class TicketFactory {
    public static Ticket createTicket(int ticketId, int flightId, int statusId, String ticketDescription, double price, int seatNumber) {
        StringHelper.checkStringParam("ticketDescription", ticketDescription);
        Validator.greaterThan(0, price);
        Validator.greaterThan(0, seatNumber);

        return new Ticket(ticketId, flightId, statusId, ticketDescription, price, seatNumber);
    }
}
