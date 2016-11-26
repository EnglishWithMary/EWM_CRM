package evg.testt.dao;

import evg.testt.model.CardPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardPersonDao extends JpaRepository<CardPerson, Integer> {

}
