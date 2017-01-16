package evg.testt.service.impl;

import evg.testt.model.Teacher;
import evg.testt.dao.TeacherRepository;
import evg.testt.service.TeacherService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TeacherServiceImpl extends RegisteredUserServiceImpl<Teacher, TeacherRepository> implements TeacherService {



}