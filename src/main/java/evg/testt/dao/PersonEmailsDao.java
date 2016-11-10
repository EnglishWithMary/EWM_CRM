package evg.testt.dao;

import evg.testt.model.PersonEmails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonEmailsDao extends JpaRepository <PersonEmails, Integer> {

}
