package evg.testt.dao.Jpa;

import evg.testt.dao.MosaicShowRepository;
import evg.testt.model.Person;

import javax.persistence.TypedQuery;
import java.util.Collections;
import java.util.List;

/**
 * Created by nikolay on 04.12.16.
 */
public class MosaicShowRepositoryImpl extends BaseRepositoryJpaImpl<Person> implements MosaicShowRepository{
    public List<Person> findPersonByRole(int role_id) {
        List<Person> persons = Collections.EMPTY_LIST;
        TypedQuery<Person> query = em.createQuery("SELECT person FROM persons person where person.id = :id", Person.class);
        query.setParameter("id", role_id);
        persons = query.getResultList();
        return persons;
    }
}
