package evg.testt.repository;

import evg.testt.model.Group;

import java.util.Collection;

public interface GroupRepository {

    Collection<Group> getAll();

    Group findById(Integer id);

    void save(Group group);
}
