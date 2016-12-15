package evg.testt.service.impl;

import evg.testt.dao.Jpa.BaseRepositoryJpaImpl;
import evg.testt.model.Human;
import evg.testt.model.Manager;
import evg.testt.dao.ManagerRepository;
import evg.testt.service.HumanService;
import evg.testt.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
public class ManagerServiceImpl extends RegisteredUserServiceImpl<Manager, ManagerRepository>
        implements ManagerService {
}