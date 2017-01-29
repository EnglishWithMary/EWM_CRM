package evg.testt.dao;

import evg.testt.model.SearchedPerson;

import java.sql.SQLException;
import java.util.List;

public interface SearchRepository {
    List<SearchedPerson> findPersonByKeyWord(String keywords) throws SQLException;
}
