package evg.testt.service.impl;

import evg.testt.model.Manager;
import evg.testt.dao.ManagerDao;
import evg.testt.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ManagerServiceImpl extends BaseService<Manager, ManagerDao> implements ManagerService {

    @Autowired
    ManagerDao managerDao;

    @Override
    public List<Manager> getSortedByRegistrationDate() throws SQLException {
        return managerDao.findSortedByRegistrationDate();
    }

    @Override
    public List<Manager> getByPageSorted(int pageNumber) throws SQLException {
        return managerDao.findByPageSorted(pageNumber);
    }
}