package evg.testt.dao.Jpa;

import evg.testt.model.Admin;
import evg.testt.dao.AdminRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositoryJpaImpl extends StaffRepositoryJpaImpl<Admin> implements AdminRepository {

}