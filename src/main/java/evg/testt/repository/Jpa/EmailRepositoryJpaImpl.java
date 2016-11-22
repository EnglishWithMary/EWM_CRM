package evg.testt.repository.Jpa;

import evg.testt.model.Email;
import evg.testt.repository.EmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryJpaImpl extends BaseRepositoryJpaImpl<Email> implements EmailRepository{
}
