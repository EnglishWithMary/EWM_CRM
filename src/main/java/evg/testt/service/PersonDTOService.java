package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.exception.NullObjectPersonDTOException;
import evg.testt.model.*;

import java.sql.SQLException;

public interface PersonDTOService {

    public Admin getAdmin() throws SQLException;

    public Manager getManager() throws SQLException;

    public Teacher getTeacher() throws SQLException;

    public Student getStudent() throws SQLException;

    public Lead getLead() throws SQLException;

    public PersonDTOService buildPerson(PersonDTO personDTO) throws SQLException;
}
