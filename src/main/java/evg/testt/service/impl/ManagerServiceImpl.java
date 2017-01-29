package evg.testt.service.impl;

import evg.testt.dao.ManagerRepository;
import evg.testt.model.Manager;
import evg.testt.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends StaffServiceImpl<Manager, ManagerRepository>
        implements ManagerService {
}