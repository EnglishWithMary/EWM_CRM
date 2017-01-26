package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.User;

public interface UserService extends Service<User>{

    User findByUserLogin(String login);

    User getUpdatedUser (User user, PersonDTO personDTO);
}
