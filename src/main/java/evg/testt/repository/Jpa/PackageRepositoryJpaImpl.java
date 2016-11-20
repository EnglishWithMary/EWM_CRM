package evg.testt.repository.Jpa;

import evg.testt.model.Package;
import evg.testt.repository.PackageRepository;
import org.springframework.stereotype.Repository;

@Repository
public class PackageRepositoryJpaImpl extends BaseRepositoryJpaImpl<Package> implements PackageRepository {
}
