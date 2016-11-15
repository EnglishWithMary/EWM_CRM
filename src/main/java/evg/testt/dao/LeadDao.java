package evg.testt.dao;

import evg.testt.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadDao extends JpaRepository<Lead, Integer> {

}
