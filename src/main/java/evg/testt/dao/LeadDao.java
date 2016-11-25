package evg.testt.dao;

import evg.testt.model.Lead;

import java.sql.SQLException;
import java.util.List;

public interface LeadDao extends BaseDao<Lead> {
    List<Lead> findSortedByRegistrationDate() throws SQLException;
}
