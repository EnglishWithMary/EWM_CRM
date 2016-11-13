package evg.testt.repository.Jpa;

import evg.testt.model.Person;
import evg.testt.repository.PersonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class PersonRepositoryJpaImpl implements PersonRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public Person findPersonById(Integer id) {
        Query query = em.createQuery("SELECT person FROM persons person " +
                "WHERE person.id =:id");
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }

    @Override
    public Integer save(Person person) {
        if(person.getId() == null){
            em.persist(person);
            return person.getId();
        }else{
            em.merge(person);
            return person.getId();
        }
    }
}
