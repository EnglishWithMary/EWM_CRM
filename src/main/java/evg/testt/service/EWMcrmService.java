package evg.testt.service;

import evg.testt.model.*;
import evg.testt.model.Package;
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

    Integer savePerson(Person person);

    Person getPersonById(Integer id);

    Event getEventById(Integer id);

    void saveEvent(Event event);

    Collection <Event> getAllEvents();

    Group getGroupById(Integer id);

    void saveGroup(Group group);

    Collection <Group> getAllGroup();

    Package getPackageById(Integer id);

    void savePackage(Package p);

    Collection <Package> getAllPackages();

    Payment getPaymentById(Integer id);

    void savePayment(Payment payment);

    Collection <Payment> getAllPayments();

}
