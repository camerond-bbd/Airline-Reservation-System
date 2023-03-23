package co.za.bbd.ars.model;

import lombok.*;
import lombok.Data;
import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Data

public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentMethodId", nullable = false)
    private Integer paymentMethodId;

    @Column(name = "paymentMethod", nullable = false)
    private String paymentMethod;

    public PaymentMethods() {
    }

    public PaymentMethods(Integer paymentMethodId, String paymentMethod) {
        this.paymentMethodId = paymentMethodId;
        this.paymentMethod = paymentMethod;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethods)) return false;
        PaymentMethods paymentMethods = (PaymentMethods) o;
        return paymentMethodId == paymentMethods.paymentMethodId && paymentMethod == paymentMethods.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodId, paymentMethod);
    }

    @Override
    public String toString() {
        return "PaymentMethods{" +
                "paymentMethodId=" + paymentMethodId +
                "paymentMethod=" + paymentMethod +
                "}";
    }
}
