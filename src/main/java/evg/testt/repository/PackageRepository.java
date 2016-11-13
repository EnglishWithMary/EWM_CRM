package evg.testt.repository;

import evg.testt.model.Package;

import java.util.Collection;

public interface PackageRepository {

    Collection<Package> getAll();

    Package findById(Integer id);

    void save(Package p);
}
