package evg.testt.dao;

import evg.testt.model.StudentLevelHistory;

import java.util.List;

public interface StudentLevelHistoryRepository extends BaseRepository<StudentLevelHistory>{

    public List<StudentLevelHistory> getByStudentId(Integer id);

}
