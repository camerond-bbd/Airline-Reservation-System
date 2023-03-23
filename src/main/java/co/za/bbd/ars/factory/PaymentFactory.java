package co.za.bbd.ars.factory;

import co.za.bbd.ars.helpers.StringHelper;
import co.za.bbd.ars.helpers.Validator;
import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.model.Ticket;

import java.sql.Date;

public class PaymentFactory {
    public static Payment createPayment(int paymentId, int reservationId, int paymentMethodId, double amountPaid, Date paymentDate) {
        Validator.greaterThan(0, amountPaid);

        return new Payment(paymentId, reservationId, paymentMethodId, amountPaid, paymentDate);
    }
}
