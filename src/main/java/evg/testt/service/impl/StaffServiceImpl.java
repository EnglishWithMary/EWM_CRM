package evg.testt.service.impl;

import evg.testt.dao.StaffRepository;
import evg.testt.model.Staff;
import evg.testt.service.StaffService;
import org.springframework.stereotype.Service;

@Service
public abstract class StaffServiceImpl<T extends Staff, P extends StaffRepository<T>>
        extends RegisteredUserServiceImpl<T, P> implements StaffService<T> {}