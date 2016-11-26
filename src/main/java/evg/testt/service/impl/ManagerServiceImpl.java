package evg.testt.service.impl;

import evg.testt.model.Manager;
import evg.testt.repository.ManagerRepository;
import evg.testt.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl extends BaseService<Manager, ManagerRepository> implements ManagerService {
}