package evg.testt.service.impl;

import evg.testt.dao.SearchRepository;
import evg.testt.model.SearchedPerson;
import evg.testt.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository dao;

    @Override
    public List<SearchedPerson> getPersonsByKeyWord(String keyWords) throws SQLException {
        StringBuilder searchText = new StringBuilder();

        String[] words = keyWords.split("\\s");

        for (int i = 0; i < words.length; i++) {
            searchText.append(words[i] + ":*");
            if (i < words.length - 1)
                searchText.append("|");
        }

        return dao.findPersonByKeyWord(searchText.toString());
    }
}
