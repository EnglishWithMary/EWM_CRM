package evg.testt.dao.Jpa;

import evg.testt.model.Payment;
import evg.testt.dao.PaymentRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Payment> implements PaymentRepository {

}
