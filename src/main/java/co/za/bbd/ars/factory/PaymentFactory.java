package co.za.bbd.ars.factory;

import co.za.bbd.ars.helpers.Validator;
import co.za.bbd.ars.model.Payment;
import co.za.bbd.ars.model.PaymentMethods;
import co.za.bbd.ars.model.Reservation;
import java.util.Date;

public class PaymentFactory {
    public static Payment createPayment(int paymentId, Reservation reservation, PaymentMethods paymentMethod, double amountPaid, Date paymentDate) {
        Validator.greaterThan(0, amountPaid);

        return new Payment(paymentId, reservation, paymentMethod, amountPaid, paymentDate);
    }
}
