package evg.testt.service.impl;

import evg.testt.dao.GroupDao;
import evg.testt.model.Group;
import evg.testt.model.Teacher;
import evg.testt.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl extends BaseService<Group, GroupDao> implements GroupService{

    @Autowired
    GroupDao groupDao;

    @Override
    public List<Group> getByTeacher(Teacher teacher) throws SQLException {
        return groupDao.findByTeacher(teacher);
    }
}
