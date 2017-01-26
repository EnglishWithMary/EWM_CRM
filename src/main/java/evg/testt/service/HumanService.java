package evg.testt.service;

import evg.testt.dto.PersonDTO;
import evg.testt.model.Human;

import java.sql.SQLException;
import java.util.List;

public interface HumanService<T extends Human> extends Service <T> {

    void delete (T o) throws SQLException;

    void trash (T o) throws SQLException;

    void restore (T o) throws SQLException;

    List<T> getSortedByRegistrationDate() throws SQLException;

    List<T> getByPageSorted(int pageNumber) throws SQLException;

    void updatePosition(T human, PersonDTO personDTO) throws SQLException;
}
