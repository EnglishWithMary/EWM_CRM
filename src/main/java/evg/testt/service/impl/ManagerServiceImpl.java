package evg.testt.service.impl;

import evg.testt.model.Manager;
import evg.testt.repository.ManagerRepository;
import evg.testt.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends BaseService<Manager, ManagerRepository> implements ManagerService {

}