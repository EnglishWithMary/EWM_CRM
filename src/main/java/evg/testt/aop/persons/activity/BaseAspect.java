package evg.testt.aop.persons.activity;

import evg.testt.aop.persons.activity.service.ActivityAspect;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Activity;
import evg.testt.model.Person;
import evg.testt.service.ActivityService;
import evg.testt.service.PersonService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by User on 27.11.2016.
 */
public abstract class BaseAspect implements ActivityAspect{

    @Autowired
    ActivityService activityService;

    @Autowired
    PersonService personService;

    @Override
    @Around(value = "pointcut()")
    public Object doActivity(ProceedingJoinPoint pjp) throws Throwable {
        Object ret_obj;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Activity activity = new Activity();
        Person person;

        try {
            String pname = pjp.getTarget().getClass().getName();
            person = personService.getPersonByUserLogin(name);
            activity.setPerson(person);
            activity.setActivity(pjp.getSignature().getName()+"ed " + pname + " person.");
            activityService.insertActivity(activity);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersonRoleNotFoundException e) {
            e.printStackTrace();
        }

        ret_obj = pjp.proceed();
        return ret_obj;
    }
}
