package evg.testt.dao.Jpa;


import evg.testt.dao.HumanRepository;
import evg.testt.exception.PersonFieldTypeNotFoundException;
import evg.testt.model.Human;
import evg.testt.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public abstract class HumanRepositoryJpaImpl<T extends Human> extends BaseRepositoryJpaImpl<T>
        implements HumanRepository<T>{

    public Collection<T> findAll(){
        Query query = em.createQuery("select t from "+entityClass.getName()+
                " t join t.person p where p.state ='ACTIVE' or p.state ='STATE_ACTIVE'");
        List<T> result =(List<T>) query.getResultList();
        if (result.size()>0)
            return result;
        else
            return null;
    }
}
