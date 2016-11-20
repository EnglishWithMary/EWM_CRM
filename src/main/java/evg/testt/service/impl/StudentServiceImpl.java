package evg.testt.service.impl;

import evg.testt.dao.StudentDao;
import evg.testt.model.Student;
import evg.testt.repository.StudentRepository;
import evg.testt.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends BaseService<Student, StudentRepository> implements StudentService {

}