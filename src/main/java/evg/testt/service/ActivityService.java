package evg.testt.service;

import evg.testt.model.Activity;

import java.sql.SQLException;

public interface ActivityService {
    void insertActivity(Activity activity) throws SQLException;
}
