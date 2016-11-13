package evg.testt.service.impl;

import evg.testt.dao.PersonEmailsDao;
import evg.testt.model.PersonEmails;
import evg.testt.service.PersonEmailsService;
import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.springframework.stereotype.Service;

@Service
public class PersonEmailsServiceImpl extends BaseService<PersonEmails,PersonEmailsDao> implements PersonEmailsService{
}
