package evg.testt.dao.Jpa;

import evg.testt.dao.StaffRepository;
import evg.testt.model.Staff;
import org.springframework.stereotype.Repository;

@Repository
public abstract class StaffRepositoryJpaImpl<T extends Staff> extends RegisteredUserRepositoryJpaImpl<T>
        implements StaffRepository<T> {}
