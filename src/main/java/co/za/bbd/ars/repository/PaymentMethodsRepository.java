package co.za.bbd.ars.repository;

import co.za.bbd.ars.model.PaymentMethods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
    List<PaymentMethods> findAllByPaymentMethod(String paymentMethodName);
}
