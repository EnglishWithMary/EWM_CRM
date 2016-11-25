package evg.testt.dao.Jpa;

import evg.testt.dao.PackageDao;
import evg.testt.model.Package;
import org.springframework.stereotype.Repository;

@Repository
public class PackageDaoJpaImpl extends BaseDaoJpaImpl<Package> implements PackageDao {
}
