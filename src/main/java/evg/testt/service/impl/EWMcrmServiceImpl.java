package evg.testt.service.impl;

import evg.testt.model.*;
import evg.testt.model.Package;
import evg.testt.repository.*;
import evg.testt.service.EWMcrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EWMcrmServiceImpl implements EWMcrmService {

    AdminRepository adminRepository;
    ManagerRepository managerRepository;
    TeacherRepository teacherRepository;
    StudentRepository studentRepository;
    PersonRepository personRepository;
    EventRepository eventRepository;
    GroupRepository groupRepository;
    PackageRepository packageRepository;
    PaymentRepository paymentRepository;

    @Autowired
    public EWMcrmServiceImpl(AdminRepository adminRepository, ManagerRepository managerRepository,
                             TeacherRepository teacherRepository, StudentRepository studentRepository,
                             PersonRepository personRepository, EventRepository eventRepository,
                             GroupRepository groupRepository, PackageRepository packageRepository,
                             PaymentRepository paymentRepository) {
        this.adminRepository = adminRepository;
        this.managerRepository = managerRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.personRepository= personRepository;
        this.eventRepository = eventRepository;
        this.groupRepository = groupRepository;
        this.packageRepository = packageRepository;
        this.paymentRepository = paymentRepository;
    }

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
    public void saveManager(Manager manager) { managerRepository.save(manager);

    }

    @Override
    public Collection<Manager> getAllManagers() {
        return managerRepository.getAll();
    }

    @Override
    public Manager getManagerById(Integer id) {
        return managerRepository.findById(id);
    }

    @Override
    public void saveTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public Collection<Teacher> getAllTeachers() {
        return teacherRepository.getAll();
    }

    @Override
    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Collection<Student> getAllStudents() {
        return studentRepository.getAll();
    }

    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Integer savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findPersonById(id);
    }

    @Override
    public Event getEventById(Integer id) {
        return eventRepository.findById(id);
    }

    @Override
    public void saveEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Collection<Event> getAllEvents() {
        return eventRepository.getAll();
    }

    @Override
    public Group getGroupById(Integer id) {
        return groupRepository.findById(id);
    }

    @Override
    public void saveGroup(Group group) {
        groupRepository.save(group);
    }

    @Override
    public Collection<Group> getAllGroup() {
        return groupRepository.getAll();
    }

    @Override
    public Package getPackageById(Integer id) {
        return packageRepository.findById(id);
    }

    @Override
    public void savePackage(Package p) {
        packageRepository.save(p);
    }

    @Override
    public Collection<Package> getAllPackages() {
        return packageRepository.getAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    @Override
    public void savePayment(Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public Collection<Payment> getAllPayments() {
        return paymentRepository.getAll();
    }
}
