package evg.testt.service;

import evg.testt.model.Admin;
import evg.testt.model.Manager;
import evg.testt.model.Student;
import evg.testt.model.Teacher;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Transactional
public interface EWMcrmService {

    void saveAdmin(Admin admin);

    Collection<Admin> getAllAdmins();

    Admin getAdminById(Integer id);

    void saveManager(Manager manager);

    Collection<Manager> getAllManagers();

    Manager getManagerById(Integer id);

    void saveTeacher(Teacher teacher);

    Collection<Teacher> getAllTeachers();

    Teacher getTeacherById(Integer id);

    void saveStudent(Student student);

    Collection<Student> getAllStudents();

    Student getStudentById(Integer id);

}
