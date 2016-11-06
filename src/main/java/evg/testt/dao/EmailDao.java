package evg.testt.dao;

import evg.testt.model.PersonEmails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailDao extends JpaRepository<PersonEmails, Integer> {

}
