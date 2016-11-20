package evg.testt.service.impl;

import evg.testt.dao.EmailDao;
import evg.testt.model.Email;
import evg.testt.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends BaseService<Email, EmailDao> implements EmailService {

}