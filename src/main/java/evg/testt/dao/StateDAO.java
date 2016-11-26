package evg.testt.dao;

import evg.testt.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateDAO extends JpaRepository<State, Integer>{
}
