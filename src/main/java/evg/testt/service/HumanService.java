package evg.testt.service;

import evg.testt.model.Human;

import java.sql.SQLException;

public interface HumanService<T extends Human> extends Service <T> {

    void trash (T o) throws SQLException;
}
