package evg.testt.repository.Jpa;

import evg.testt.model.Person;
import evg.testt.repository.PersonRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepositoryJpaImpl extends BaseRepositoryJpaImpl<Person> implements PersonRepository{

}
