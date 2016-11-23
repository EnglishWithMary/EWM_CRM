package evg.testt.repository;

import evg.testt.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentRepository extends BaseRepository<Student>{
    List<Student> findSortedByRegistrationDate() throws SQLException;
}
