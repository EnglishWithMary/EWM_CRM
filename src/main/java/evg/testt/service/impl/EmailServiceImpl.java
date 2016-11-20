package evg.testt.service.impl;

import evg.testt.model.Email;
import evg.testt.repository.EmailRepository;
import evg.testt.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl extends BaseService<Email, EmailRepository> implements EmailService {

}