package co.za.bbd.ars.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    @NotNull
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer paymentId;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="reservationId")
    @NotNull
    private Reservation reservation;

    @OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="paymentMethodId")
    @NotNull
    private PaymentMethods paymentMethod;
    @NotNull
    private double amountPaid;
    @NotNull
    private Date paymentDate;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Payment payment = (Payment) o;
//        return paymentId == payment.paymentId && reservation == payment.reservation && paymentMethod == payment.paymentMethod && amountPaid == payment.amountPaid;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.amountPaid, amountPaid) == 0 && paymentId.equals(payment.paymentId) && reservation.equals(payment.reservation) && paymentMethod.equals(payment.paymentMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, reservation, paymentMethod, amountPaid);
    }
}
