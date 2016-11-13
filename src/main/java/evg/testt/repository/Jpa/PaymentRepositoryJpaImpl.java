package evg.testt.repository.Jpa;

import evg.testt.model.Payment;
import evg.testt.repository.PaymentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;

@Repository
public class PaymentRepositoryJpaImpl implements PaymentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public Collection<Payment> getAll() {
        Query query = em.createQuery("SELECT payment FROM payments payment");
        return query.getResultList();
    }

    @Override
    public Payment findById(Integer id) {
        Query query = em.createQuery("SELECT payment FROM payments payment WHERE payment.id =:id");
        query.setParameter("id", id);
        return (Payment) query.getSingleResult();
    }

    @Override
    public void save(Payment payment) {
        if(payment.getId() == null){
            em.persist(payment);
        } else {
            em.merge(payment);
        }
    }
}
