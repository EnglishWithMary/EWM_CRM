package evg.testt.dao;

import evg.testt.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardDao extends JpaRepository<Card, Integer> {

}
