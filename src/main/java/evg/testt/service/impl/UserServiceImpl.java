package evg.testt.service.impl;

import evg.testt.dao.UserDao;
import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by clay on 25.09.16.
 */

@Service
public class UserServiceImpl extends BaseService<User, UserDao> implements UserService{
}
