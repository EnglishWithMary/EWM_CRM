package evg.testt.dao;

import evg.testt.model.Teacher;

import java.sql.SQLException;

public interface TeacherRepository extends RegisteredUserRepository<Teacher> {

    Teacher findTeacherByPersonId(Integer personId) throws SQLException;
}
