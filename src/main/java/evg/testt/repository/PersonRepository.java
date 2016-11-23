package evg.testt.repository;

import evg.testt.model.Person;

public interface PersonRepository extends BaseRepository <Person>{

    public Person findPersonByUserLogin(String userLogin);

}
