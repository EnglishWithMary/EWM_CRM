package evg.testt.repository;

import evg.testt.model.Lead;

import java.sql.SQLException;
import java.util.List;

public interface LeadRepository extends BaseRepository<Lead>{
    List<Lead> findSortedByRegistrationDate() throws SQLException;
}
