package evg.testt.dao.Jpa;

import evg.testt.model.Lead;
import evg.testt.dao.LeadRepository;
import org.springframework.stereotype.Repository;

@Repository
public class LeadRepositoryJpaImpl extends BaseRepositoryJpaImpl<Lead> implements LeadRepository {
}
