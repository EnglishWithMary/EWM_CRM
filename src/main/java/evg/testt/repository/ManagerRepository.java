package evg.testt.repository;

import evg.testt.model.Manager;

import java.util.Collection;

public interface ManagerRepository {

    Collection<Manager> getAll();

    Manager findById(Integer id);

    void save(Manager manager);
}
