package evg.testt.service.impl;

import evg.testt.dao.DepartmentDao;
import evg.testt.model.Department;
import evg.testt.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl extends BaseService<Department, DepartmentDao> implements DepartmentService{
    @Override
    public List<Department> getAllWithEmployeers() {
        List<Department> list = null;

        list = dao.findAll();

//        for(Department d: list)
//            d.getEmployees();

        return list;
    }
}
