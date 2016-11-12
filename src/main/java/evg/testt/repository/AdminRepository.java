package evg.testt.repository;

import evg.testt.model.Admin;

import java.util.Collection;

public interface AdminRepository {

    Collection<Admin> getAll();

    Admin findById(Integer id);

    void save(Admin admin);
}
