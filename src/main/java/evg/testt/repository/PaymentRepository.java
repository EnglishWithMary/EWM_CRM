package evg.testt.repository;

import evg.testt.model.Payment;

import java.util.Collection;

public interface PaymentRepository {

    Collection<Payment> getAll();

    Payment findById(Integer id);

    void save(Payment payment);
}
