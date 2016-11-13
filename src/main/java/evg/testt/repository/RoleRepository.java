package evg.testt.repository;

import evg.testt.model.Role;

import java.util.Collection;

public interface RoleRepository {

    Collection<Role> getAll();

    Role findById(Integer id);

    void save(Role role);
}
