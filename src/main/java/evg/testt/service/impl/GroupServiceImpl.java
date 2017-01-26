package evg.testt.service.impl;

import evg.testt.dto.GroupDTO;
import evg.testt.model.Group;
import evg.testt.model.Student;
import evg.testt.model.Teacher;
import evg.testt.dao.GroupRepository;
import evg.testt.service.GroupService;
import evg.testt.service.LanguageService;
import evg.testt.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class GroupServiceImpl extends BaseService<Group, GroupRepository>
        implements GroupService{

    @Autowired
    TeacherService teacherService;
    @Autowired
    LanguageService languageService;

    @Override
    public List<Group> getByTeacher(Teacher teacher) throws SQLException {
        return dao.findByTeacher(teacher);
    }

    @Override
    public List<Group> getByGroup(Group group) throws SQLException {
        return dao.findByGroup(group);
    }

    @Override
    public void updateGroup(Group group, GroupDTO groupDTO) throws SQLException{

        group.setName(groupDTO.getName());

        if (groupDTO.getTeacherId() != null) {
            group.setTeacher(teacherService.getById(groupDTO.getTeacherId()));
        }
        if (groupDTO.getLanguageId() != null) {
            group.setLanguage(languageService.getById(groupDTO.getLanguageId()));
        }

        dao.save(group);

        return;
    }
}



