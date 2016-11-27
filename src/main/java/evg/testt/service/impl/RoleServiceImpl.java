package evg.testt.service.impl;

import evg.testt.model.Role;
import evg.testt.dao.RoleRepository;
import evg.testt.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseService<Role, RoleRepository> implements RoleService{
}
