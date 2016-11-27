package evg.testt.dao.Jpa;

import evg.testt.dao.PaymentDao;
import evg.testt.model.Payment;
import org.springframework.stereotype.Repository;

@Repository
public class PaymentDaoJpaImpl extends BaseDaoJpaImpl<Payment> implements PaymentDao {

}
