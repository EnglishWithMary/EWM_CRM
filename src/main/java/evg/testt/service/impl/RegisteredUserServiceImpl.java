package evg.testt.service.impl;

import evg.testt.dao.HumanRepository;
import evg.testt.dao.RegisteredUserRepository;
import evg.testt.model.Human;
import evg.testt.model.RegisteredUser;
import evg.testt.service.HumanService;
import evg.testt.service.RegisteredUserService;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public abstract
class RegisteredUserServiceImpl<T extends RegisteredUser, P extends RegisteredUserRepository<T>>
        extends HumanServiceImpl<T, P> implements RegisteredUserService<T> {
}