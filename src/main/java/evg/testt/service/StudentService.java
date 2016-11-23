package evg.testt.service;

import evg.testt.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentService extends Service<Student> {
    List<Student> getSortedByRegistrationDate()throws SQLException;
}
