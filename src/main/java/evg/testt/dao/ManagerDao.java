package evg.testt.dao;

import evg.testt.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerDao extends JpaRepository<Manager, Integer> {

}
