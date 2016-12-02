package evg.testt.dao.Jpa;


import evg.testt.dao.HumanRepository;
import evg.testt.model.Human;
import evg.testt.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public abstract class HumanRepositoryJpaImpl<T extends Human> extends BaseRepositoryJpaImpl<Human> implements HumanRepository {

    @Override
    public void delete(T human){

        Person person = human.getPerson();

        Query query = em.createQuery("UPDATE persons SET person.state='STATE_DELETED' FROM persons WHERE person.id =:id");
        query.setParameter("id", person.getId());
    }
}
