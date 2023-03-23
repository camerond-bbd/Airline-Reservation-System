package co.za.bbd.ars.controller;

import co.za.bbd.ars.model.PaymentMethods;
import co.za.bbd.ars.service.impl.PaymentMethodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class PaymentMethodsController {
    private final PaymentMethodsServiceImpl paymentMethodsService;

    @Autowired
    public PaymentMethodsController(PaymentMethodsServiceImpl paymentMethodsService) {
        this.paymentMethodsService = paymentMethodsService;
    }
    @RequestMapping(value = "/{paymentMethod}/update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity updatePaymentMethod(
            @PathVariable Integer paymentMethodId,
            @RequestBody PaymentMethods paymentMethod
    ) {
        try {
            PaymentMethods updatePaymentMethod = paymentMethodsService.updatePaymentMethods(paymentMethodId, paymentMethod);
            return new ResponseEntity<>(updatePaymentMethod, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
