package evg.testt.service.impl;

import evg.testt.model.Person;
import evg.testt.repository.PersonRepository;
import evg.testt.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl extends BaseService<Person, PersonRepository> implements PersonService {

}
