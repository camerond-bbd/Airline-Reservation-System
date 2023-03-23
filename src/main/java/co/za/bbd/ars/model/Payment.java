package co.za.bbd.ars.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Date;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Data
@AllArgsConstructor
public class Payment {
    @NotNull
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int paymentId;
    @NotNull
    private int reservationId;
    @NotNull
    private int paymentMethodId;
    @NotNull
    private double amountPaid;
    @NotNull
    private Date paymentDate;

    public Payment() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentId == payment.paymentId && reservationId == payment.reservationId && paymentMethodId == payment.paymentMethodId && amountPaid == payment.amountPaid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, reservationId, paymentMethodId, amountPaid);
    }
}
