package evg.testt.dao.Jpa;

import evg.testt.model.Package;
import evg.testt.dao.PackageRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PackageRepositoryJpaImpl extends BaseRepositoryJpaImpl<Package> implements PackageRepository {
}
