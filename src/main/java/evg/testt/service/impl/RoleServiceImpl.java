package evg.testt.service.impl;

import evg.testt.dao.RoleDao;
import evg.testt.model.Role;
import evg.testt.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<Role, RoleDao> implements RoleService{
}
