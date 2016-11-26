package evg.testt.repository.Jpa;

import evg.testt.model.Lead;
import evg.testt.repository.LeadRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LeadRepositoryJpaImpl extends BaseRepositoryJpaImpl<Lead> implements LeadRepository {
}
