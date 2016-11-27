package evg.testt.aop.persons.activity;

import evg.testt.aop.persons.activity.service.ActivityAspect;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Activity;
import evg.testt.model.Person;
import evg.testt.service.ActivityService;
import evg.testt.service.PersonService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by User on 27.11.2016.
 */
@Component
@Aspect
public class AddActivity extends BaseAspect implements ActivityAspect{

    @Override
    @Pointcut("execution(* evg.testt.service.impl.BaseService.insert(..))")
    public void pointcut() {}

}
