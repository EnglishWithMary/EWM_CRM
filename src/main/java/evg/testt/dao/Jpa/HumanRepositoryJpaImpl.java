package evg.testt.dao.Jpa;

import evg.testt.dao.HumanRepository;
import evg.testt.model.Human;
import evg.testt.model.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public abstract class HumanRepositoryJpaImpl<T extends Human> extends BaseRepositoryJpaImpl<T> implements HumanRepository<T> {

//    @Override
//    public void delete(T human){
//        Person person = human.;
//        Query query = em.createQuery("UPDATE persons SET person.state='STATE_DELETED' FROM persons WHERE person.id =:id");
//        query.setParameter("id", person.getId());
}
