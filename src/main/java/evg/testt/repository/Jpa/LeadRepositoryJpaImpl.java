package evg.testt.repository.Jpa;

import evg.testt.model.Lead;
import evg.testt.repository.LeadRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LeadRepositoryJpaImpl extends BaseRepositoryJpaImpl<Lead> implements LeadRepository {
}
