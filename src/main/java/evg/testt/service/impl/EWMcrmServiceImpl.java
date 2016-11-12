package evg.testt.service.impl;

import evg.testt.model.Admin;
import evg.testt.model.Manager;
import evg.testt.model.Student;
import evg.testt.model.Teacher;
import evg.testt.repository.AdminRepository;
import evg.testt.service.EWMcrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EWMcrmServiceImpl implements EWMcrmService {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public void saveAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public Collection<Admin> getAllAdmins() {
        return adminRepository.getAll();
    }

    @Override
    public Admin getAdminById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public void saveManager(Manager manager) {

    }

    @Override
    public Collection<Manager> getAllManagers() {
        return null;
    }

    @Override
    public Manager getManagerById(Integer id) {
        return null;
    }

    @Override
    public void saveTeacher(Teacher teacher) {

    }

    @Override
    public Collection<Teacher> getAllTeachers() {
        return null;
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return null;
    }

    @Override
    public void saveStudent(Student student) {

    }

    @Override
    public Collection<Student> getAllStudents() {
        return null;
    }

    @Override
    public Student getStudentById(Integer id) {
        return null;
    }
}
