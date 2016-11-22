package evg.testt.service.impl;

import evg.testt.model.Admin;
import evg.testt.repository.AdminRepository;
import evg.testt.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseService<Admin, AdminRepository> implements AdminService {

}