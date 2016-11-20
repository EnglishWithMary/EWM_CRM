package evg.testt.repository.Jpa;

import evg.testt.model.Payment;
import evg.testt.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Payment> implements PaymentRepository {

}
