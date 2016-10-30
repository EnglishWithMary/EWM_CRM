package evg.testt.dao;

import evg.testt.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
