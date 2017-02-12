package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Teacher;
import evg.testt.model.TeacherLevelEnum;
import evg.testt.service.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;


public interface TeacherService extends StaffService<Teacher> {

    Teacher getUpdateTeacher(Teacher teacher, PersonDTO personDTO) throws ParseException;

    List<Teacher> getTeacherByLevel(TeacherLevelEnum teacherLevel)throws SQLException;
}