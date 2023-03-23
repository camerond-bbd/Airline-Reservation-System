package co.za.bbd.ars.dtos;

import co.za.bbd.ars.model.PaymentMethods;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class PaymentMethodsData {
    private String paymentMethod;

    public PaymentMethods getPaymentMethodObject() {
        return new PaymentMethods(
                null,
                this.paymentMethod
        );
    }
}
