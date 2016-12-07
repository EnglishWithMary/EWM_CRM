package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.NullObjectPersonDTOException;
import evg.testt.model.*;
import evg.testt.service.PersonDTOService;
import evg.testt.service.PersonService;
import evg.testt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonDTOServiceImpl implements PersonDTOService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PersonService personService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private PersonDTO personDTO;

    @Override
    public Admin getAdmin() throws SQLException, ParseException {
        Admin admin = new Admin();
        admin.setPerson(getPerson());
        admin.setUser(getUser(UserRole.ROLE_ADMIN));

        return admin;
    }

    @Override
    public Admin updateAdmin(Admin admin) throws SQLException, ParseException {
        if (admin == null){
            admin = getAdmin();
        }
        else {
            admin.setPerson(getPerson());
            admin.setUser(getUser(UserRole.ROLE_ADMIN));
        }
        return admin;
    }

    @Override
    public Manager getManager() throws SQLException, ParseException {
        Manager manager = new Manager();
        manager.setPerson(getPerson());
        manager.setUser(getUser(UserRole.ROLE_MANAGER));

        return manager;
    }

    @Override
    public Manager updateManager(Manager manager) throws SQLException, ParseException {
        if (manager == null){
            manager = getManager();
        }
        else {
            manager.setPerson(getPerson());
            manager.setUser(getUser(UserRole.ROLE_MANAGER));
        }
        return manager;
    }

    @Override
    public Teacher getTeacher() throws SQLException, ParseException {
        Teacher teacher = new Teacher();
        teacher.setPerson(getPerson());
        teacher.setUser(getUser(UserRole.ROLE_TEACHER));

        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) throws SQLException, ParseException {
        if (teacher == null){
            teacher = getTeacher();
        }
        else {
            teacher.setPerson(getPerson());
            teacher.setUser(getUser(UserRole.ROLE_TEACHER));
        }
        return teacher;
    }

    @Override
    public Student getStudent() throws SQLException, ParseException {
        Student student = new Student();
        student.setPerson(getPerson());
        student.setUser(getUser(UserRole.ROLE_STUDENT));

        return student;
    }

    @Override
    public Student updateStudent(Student student) throws SQLException, ParseException {
        if (student == null){
            student = getStudent();
        }
        else {
            student.setPerson(getPerson());
            student.setUser(getUser(UserRole.ROLE_STUDENT));
        }
        return student;
    }

    @Override
    public Lead getLead() throws NullObjectPersonDTOException, ParseException {
        Lead newLead = new Lead();
        newLead.setPerson(getPerson());
        return newLead;
    }

    @Override
    public Lead updateLead(Lead lead) throws SQLException, ParseException {
        if (lead == null){
            lead = getLead();
        }
        else {
            lead.setPerson(getPerson());
        }
        return lead;
    }

    public PersonDTOService buildPerson(PersonDTO personDTO) throws SQLException {
        if (personDTO == null) {
            throw new NullObjectPersonDTOException("Can`t build person with empty data. First initialize DTO object.");
        }
        this.personDTO = personDTO;

        return this;
    }

    public Person getPerson() throws NullObjectPersonDTOException, ParseException {
        if (this.personDTO != null)
            return new Person() {
                {
                    this.setFirstName(personDTO.getFirstName());
                    this.setLastName(personDTO.getLastName());
                    this.setMiddleName(personDTO.getMiddleName());
                    this.setComments(personDTO.getComments());
                    this.setOrganization(personDTO.getOrganization());
                    this.setBirthdayDate(getDateFromString(personDTO.getBirthdayDate()));
                    this.setEmail(new Email(personDTO.getEmail()));
                    this.setState(new State());
                }
            };
        else
            throw new NullObjectPersonDTOException("Can`t build person with empty data. First initialize DTO object.");
    }

    public Person updatePerson(Person person) throws SQLException, ParseException {
        if (this.personDTO != null) {
            person.setFirstName(personDTO.getFirstName());
            person.setLastName(personDTO.getLastName());
            person.setMiddleName(personDTO.getMiddleName());
            person.setComments(personDTO.getComments());
            person.setOrganization(personDTO.getOrganization());
            person.setBirthdayDate(getDateFromString(personDTO.getBirthdayDate()));
            person.setEmail(new Email(personDTO.getEmail()));
            person.setState(new State());
            personService.update(person);
            return person;
        }
        else{
            return getPerson();
        }
    }

    private User getUser(UserRole userRole) throws SQLException {
        Role role = roleService.getById(userRole.getRoleId());

        if (this.personDTO != null)
            return new User() {
                {
                    this.setRole(role);
                    this.setLogin(personDTO.getLogin());
                    this.setPassword(passwordEncoder.encode(personDTO.getPassword()));
                }
            };
        else
            throw new NullObjectPersonDTOException("Can`t build person with empty data. First initialize DTO object.");
    }

    public Date getDateFromString(String dateFromForm) throws ParseException {
        if (dateFromForm != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(dateFromForm);
            return date;
        }
        else {
            return null;
        }
    }

}
