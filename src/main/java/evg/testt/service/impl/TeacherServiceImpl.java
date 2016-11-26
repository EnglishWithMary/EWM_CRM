package evg.testt.service.impl;

import evg.testt.model.Teacher;
import evg.testt.repository.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl extends BaseService<Teacher, TeacherRepository> implements TeacherService {
}