package evg.testt.service;

import evg.testt.model.Group;
import evg.testt.model.Teacher;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GroupService extends Service<Group> {

    //@Query("SELECT g FROM Groups g WHERE g.teacher = 'teacher'")
    public List<Group> getByTeacher(Teacher teacher) ;
}

