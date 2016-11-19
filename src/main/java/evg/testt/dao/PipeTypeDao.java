package evg.testt.dao;


import evg.testt.model.PipeType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PipeTypeDao extends JpaRepository<PipeType, Integer> {
}
