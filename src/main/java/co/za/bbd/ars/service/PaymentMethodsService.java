package co.za.bbd.ars.service;

import co.za.bbd.ars.model.PaymentMethods;

public interface PaymentMethodsService extends IService<PaymentMethods, Integer> {
    PaymentMethods updatePaymentMethods(Integer paymentMethodId, PaymentMethods paymentMethods);
}
