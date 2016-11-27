package evg.testt.service.impl;

import evg.testt.model.Lead;
import evg.testt.dao.LeadDao;
import evg.testt.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class LeadServiceImpl extends BaseService<Lead, LeadDao> implements LeadService {

    @Autowired
    LeadDao leadDao;

    @Override
    public List<Lead> getSortedByRegistrationDate() throws SQLException {
        return leadDao.findSortedByRegistrationDate();
    }
}