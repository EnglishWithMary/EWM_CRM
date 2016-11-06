package evg.testt.dao;


import evg.testt.model.Package;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageDao extends JpaRepository<Package, Integer> {

}
