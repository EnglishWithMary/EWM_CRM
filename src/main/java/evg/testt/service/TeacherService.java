package evg.testt.service;

import evg.testt.model.Teacher;
import evg.testt.service.Service;

import java.sql.SQLException;
import java.util.List;


public interface TeacherService extends RegisteredUserService<Teacher> {

    public List<Teacher> getTeacherByLevel(int teacherLevel)throws SQLException;

}