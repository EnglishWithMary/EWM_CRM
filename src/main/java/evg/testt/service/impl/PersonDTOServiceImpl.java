package evg.testt.service.impl;

import evg.testt.dto.PersonDTO;
import evg.testt.model.*;
import evg.testt.service.CardService;
import evg.testt.service.PersonDTOService;
import evg.testt.service.PersonService;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class PersonDTOServiceImpl<T extends RegisteredUser> implements PersonDTOService {

    @Autowired
    PersonService personService;

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

//    public Integer updatePersonPositionOnPipeline(Person person, PersonDTO personDTO) throws SQLException{
//
//        Integer personId = person.getId();
//        Integer cardId = personDTO.getCardId();
//        Card card;
//
//        if (personId == null){
//            card = cardService.getById(cardId);
//
////          Add new person to Card
//            card.getPersons().add(person);
//            cardService.update(card);
//        }
//        else {
//            card = cardService.getCardByPerson(person);
//
//            if (!cardId.equals(card.getId())) {
//
////              Delete person from old Card
//                card.getPersons().remove(person);
//                cardService.update(card);
//
////              Add person to new Card
//                card = cardService.getById(cardId);
//                card.getPersons().add(person);
//                cardService.update(card);
//            }
//        }
//
//        return card.getPersons().size() + 1;
//    }

}