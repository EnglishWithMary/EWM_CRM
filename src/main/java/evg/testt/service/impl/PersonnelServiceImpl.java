package evg.testt.service.impl;

import evg.testt.dao.PersonnelRepository;
import evg.testt.model.Personnel;
import evg.testt.service.PersonnelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonnelServiceImpl extends BaseService<Personnel, PersonnelRepository> implements PersonnelService {

}
