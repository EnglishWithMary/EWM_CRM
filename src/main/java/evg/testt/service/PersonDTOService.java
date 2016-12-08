package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.NullObjectPersonDTOException;
import evg.testt.model.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public interface PersonDTOService {

    public Admin getAdmin() throws SQLException, ParseException;

    public Manager getManager() throws SQLException, ParseException;

    public Teacher getTeacher() throws SQLException, ParseException;

    public Student getStudent() throws SQLException, ParseException;

    public Lead getLead() throws SQLException, ParseException;

    public Admin updateAdmin(Admin admin) throws SQLException, ParseException;

    public Manager updateManager(Manager manager) throws SQLException, ParseException;

    public Teacher updateTeacher(Teacher teacher) throws SQLException, ParseException;

    public Student updateStudent(Student student) throws SQLException, ParseException;

    public Lead updateLead(Lead lead) throws SQLException, ParseException;

    public Person getPerson() throws NullObjectPersonDTOException, ParseException;

    public Person updatePerson(Person person) throws SQLException, ParseException;

    public PersonDTOService buildPerson(PersonDTO personDTO) throws SQLException;

    public Date getDateFromString(String date) throws ParseException;
}
