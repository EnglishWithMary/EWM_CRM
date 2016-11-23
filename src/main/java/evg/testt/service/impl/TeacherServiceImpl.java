package evg.testt.service.impl;

import evg.testt.dao.TeacherDao;
import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl extends BaseService<Teacher, TeacherRepository> implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public List<Teacher> getSortedByRegistrationDate() throws SQLException {
        return teacherRepository.findSortedByRegistrationDate();
    }
}