package evg.testt.dao.Jpa;

import evg.testt.model.Email;
import evg.testt.dao.EmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryJpaImpl extends BaseRepositoryJpaImpl<Email> implements EmailRepository{

}
