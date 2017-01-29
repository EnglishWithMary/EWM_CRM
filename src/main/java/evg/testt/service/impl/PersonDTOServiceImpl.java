package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Person;
import evg.testt.model.Teacher;
import evg.testt.service.TeacherService;
import evg.testt.model.RegisteredUser;
import evg.testt.model.State;
import evg.testt.model.StateType;
import evg.testt.service.PersonDTOService;
import evg.testt.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonDTOServiceImpl<T extends RegisteredUser> implements PersonDTOService {

    @Autowired
    PersonService personService;
    @Autowired
    TeacherService teacherService;

    public PersonDTO getUpdatedPersonDTO (PersonDTO personDTO, Integer personId, Integer cardId) throws SQLException{

        Person person = Person.NULL;

        if (personId != null) {
            person = personService.getById(personId);
        }

        personDTO.setFirstName(person.getFirstName());
        personDTO.setMiddleName(person.getMiddleName());
        personDTO.setLastName(person.getLastName());
        personDTO.setAvatarURL(person.getAvatarURL());
        personDTO.setEmail(person.getEmail().getEmail());
        personDTO.setCardId(cardId);
        personDTO.setPersonId(personId);

        personDTO.setBirthdayString(person.getBirthdayString());
        personDTO.setComments(person.getComments());
        personDTO.setOrganization(person.getOrganization());
        personDTO.setState(person.getState().getState().toString());
        personDTO.setRegistrationDate(person.getRegistrationDate().toString());

        personDTO.setPhone(person.getPhone());
        personDTO.setWeb(person.getWeb());
        personDTO.setAddress(person.getAddress());
        personDTO.setReferral(person.getReferral());
        personDTO.setSalary(person.getSalary());

        Teacher teacher = teacherService.getTeacherByPersonId(personId);
        personDTO.setTeacherLevel(teacher.getLevel().toString());

        personDTO.setColor(Color.black);

        personDTO.setModifyDate(person.getModifyDate().toString());

        return personDTO;
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