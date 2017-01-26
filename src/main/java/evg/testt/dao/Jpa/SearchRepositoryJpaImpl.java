package evg.testt.dao.Jpa;

import evg.testt.dao.SearchRepository;
import evg.testt.model.SearchedPerson;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class SearchRepositoryJpaImpl implements SearchRepository{

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<SearchedPerson> findPersonByKeyWord(String keywords) throws SQLException {
        List<SearchedPerson> peoples = Collections.EMPTY_LIST;

        Query nativeQuery = em.createNativeQuery("SELECT * FROM staffview WHERE searchtext @@ to_tsquery(:text);", SearchedPerson.class);
        nativeQuery.setParameter("text", keywords);
        peoples = nativeQuery.getResultList();

        return peoples;
    }

}
