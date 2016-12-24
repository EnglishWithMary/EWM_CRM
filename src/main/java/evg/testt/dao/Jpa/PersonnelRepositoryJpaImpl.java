package evg.testt.dao.Jpa;

import evg.testt.dao.PersonnelRepository;
import evg.testt.model.Personnel;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonnelRepositoryJpaImpl extends BaseRepositoryJpaImpl<Personnel> implements PersonnelRepository {

}
