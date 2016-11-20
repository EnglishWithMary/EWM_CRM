package evg.testt.repository.Jpa;

import evg.testt.model.Admin;
import evg.testt.repository.AdminRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryJpaImpl extends BaseRepositoryJpaImpl<Admin> implements AdminRepository {

}
