package evg.testt.dao;

import evg.testt.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneDao extends JpaRepository<Phone, Integer> {

}
