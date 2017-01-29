package evg.testt.service.impl;

import evg.testt.model.Admin;
import evg.testt.dao.AdminRepository;
import evg.testt.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends StaffServiceImpl<Admin, AdminRepository> implements AdminService {

}