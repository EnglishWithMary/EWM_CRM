package evg.testt.service.impl;

import evg.testt.dao.TeacherDao;
import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends BaseService<Teacher, TeacherRepository> implements TeacherService {

}