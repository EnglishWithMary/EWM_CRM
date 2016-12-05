package evg.testt.service;

import evg.testt.model.Group;
import evg.testt.model.Teacher;
import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;

public interface GroupService extends Service<Group> {

    public List<Group> getByTeacher(Teacher teacher) throws SQLException;
}

