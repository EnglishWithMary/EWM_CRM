package evg.testt.service.impl;

import evg.testt.dao.GroupRepository;
import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl extends RegisteredUserServiceImpl<Teacher, TeacherRepository> implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getTeacherByLevel(int teacherLevel) throws SQLException {
        return teacherRepository.findTeacherByLevel(teacherLevel);

    }

}