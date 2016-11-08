package evg.testt.service.impl;

import evg.testt.dao.PersonDao;
import evg.testt.model.Person;
import evg.testt.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonDao> implements PersonService {

}
