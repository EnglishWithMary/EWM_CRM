package evg.testt.service.impl;

import evg.testt.dao.GroupDao;
import evg.testt.model.Group;
import evg.testt.model.Teacher;
import evg.testt.repository.GroupRepository;
import evg.testt.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service


@Transactional
public class GroupServiceImpl extends BaseService<Group, GroupRepository> implements GroupService{

    @Autowired
    GroupRepository groupRepository;
//public class GroupServiceImpl extends BaseService<Group, GroupDao> implements GroupService {

    @Override
    public List<Group> getByTeacher(Teacher teacher) {
        return groupRepository.findByTeacher(teacher);
    }
}