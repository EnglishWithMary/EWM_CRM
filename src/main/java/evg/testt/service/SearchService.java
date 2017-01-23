package evg.testt.service;

import evg.testt.model.SearchedPerson;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public interface SearchService {
    List<SearchedPerson> getPersonsByKeyWord(String keyWords) throws SQLException;
}
