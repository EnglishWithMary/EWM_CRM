package evg.testt.dao.Jpa;

import evg.testt.dao.EmailDao;
import evg.testt.model.Email;
import org.springframework.stereotype.Repository;

@Repository
public class EmailDaoJpaImpl extends BaseDaoJpaImpl<Email> implements EmailDao {
}
