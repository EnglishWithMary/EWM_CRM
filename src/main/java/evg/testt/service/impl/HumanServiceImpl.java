package evg.testt.service.impl;

import evg.testt.dao.HumanRepository;
import evg.testt.model.Human;
import evg.testt.model.Manager;
import evg.testt.service.HumanService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Service
@Transactional
public abstract class HumanServiceImpl<T extends Human, P extends HumanRepository<T>> extends BaseService<Human, HumanRepository> implements HumanService {

}