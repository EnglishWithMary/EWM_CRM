package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.NullObjectPersonDTOException;
import evg.testt.model.*;
import evg.testt.service.PersonDTOService;
import evg.testt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PersonDTOServiceImpl implements PersonDTOService {

    @Autowired
    private RoleService roleService;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private PersonDTO personDTO;

    @Override
    public Admin getAdmin() throws SQLException {
        Admin newAdmin = new Admin();
        newAdmin.setPerson(getPerson());
        newAdmin.setUser(getUser(UserRole.ROLE_ADMIN));

        return newAdmin;
    }

    @Override
    public Manager getManager() throws SQLException {
        Manager newManager = new Manager();
        newManager.setPerson(getPerson());
        newManager.setUser(getUser(UserRole.ROLE_MANAGER));

        return newManager;
    }

    @Override
    public Teacher getTeacher() throws SQLException {
        Teacher newTeacher = new Teacher();
        newTeacher.setPerson(getPerson());
        newTeacher.setUser(getUser(UserRole.ROLE_TEACHER));

        return newTeacher;
    }

    @Override
    public Student getStudent() throws SQLException {
        Student newStudent = new Student();
        newStudent.setPerson(getPerson());
        newStudent.setUser(getUser(UserRole.ROLE_STUDENT));

        return newStudent;
    }

    @Override
    public Lead getLead() throws NullObjectPersonDTOException {
        Lead newLead = new Lead();
        newLead.setPerson(getPerson());
        return newLead;
    }

    public PersonDTOService buildPerson(PersonDTO personDTO) throws SQLException {
        if (personDTO == null)
            throw new NullObjectPersonDTOException("Can`t build person with empty data. First initialize DTO object.");

        this.personDTO = personDTO;
        return this;
    }


    private Person getPerson() throws NullObjectPersonDTOException {
        if (this.personDTO != null)
            return new Person() {
                {
                    this.setFirstName(personDTO.getFirstName());
                    this.setLastName(personDTO.getLastName());
                    this.setMiddleName(personDTO.getMiddleName());
                    this.setComments(personDTO.getComments());
                    Email newEmail = new Email();
                    newEmail.setEmail(personDTO.getEmail());
                    this.setEmail(newEmail);
                    State state = new State();
                    state.setState(StateType.STATE_ACTIVE.name());
                    this.setState(state);
                }
            };
        else
            throw new NullObjectPersonDTOException("Can`t build person with empty data. First initialize DTO object.");
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
}
