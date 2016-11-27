package evg.testt.aop.persons.activity.strategy;

import evg.testt.aop.persons.activity.strategy.service.StrategyAspectActivityExecutorService;
import evg.testt.exception.PersonRoleNotFoundException;
import evg.testt.model.Activity;
import evg.testt.model.BelongsToPerson;
import evg.testt.model.Person;
import evg.testt.service.ActivityService;
import evg.testt.service.PersonService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.sql.SQLException;

/**
 * Created by DENNNN on 27.11.2016.
 * Performing all logic that relate to insert, update, delete persons.
 * Working only if actions was executed through (Admin, Manager, Lead, Student, Teacher) services.
 */
@Service
public class CRUDAspectActivityExecutor implements StrategyAspectActivityExecutorService {
    @Autowired
    ActivityService activityService;

    @Autowired
    PersonService personService;

    @Override
    public Object executeAspect(ProceedingJoinPoint pjp) throws Throwable {
        Object ret_obj; // The object that will be returned.
        Object args[] = pjp.getArgs(); // Arguments of method that was called (insert(), update(), delete()).

        // if method have argument and this argument belongs to type BelongsToPerson
        // this is means he have filed of *.model.Person type, and
        // we can extract him.
        if(args.length > 0 && args[0] instanceof BelongsToPerson)
        {

            //Get login of logged in user.
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            String name = auth.getName();

            Activity activity = new Activity();
            Person preceedingPerson = new Person(); // Object that was passed in invoked method.

            // Get field by name from parameter(argument of method).
            Field f = pjp.getArgs()[0].getClass().getDeclaredField("person");

            // Additional checking to make sure that we got person from class.
            if(f != null) {
                f.setAccessible(true);
                preceedingPerson = (Person)f.get(pjp.getArgs()[0]); // Get person.
                StringBuilder activ = new StringBuilder();

                // Make string for activity.
                activ.append(name);
                activ.append(" is ");
                activ.append(pjp.getSignature().getName());
                activ.append(pjp.getSignature().getName().endsWith("e")? "d ": "ed ");
                activ.append("\"");
                activ.append(preceedingPerson.getFirstName());
                activ.append(" ");
                activ.append(preceedingPerson.getLastName());
                activ.append("\"");
                activ.append(" person. ");
                activ.append(args[0].getClass().getSimpleName());

                // Insert all in database.
                try {
                    activity.setPerson(personService.getPersonByUserLogin(name));
                    activity.setActivity(activ.toString());
                    activityService.insertActivity(activity);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (PersonRoleNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        ret_obj = pjp.proceed(); // Proceed invoked method.
        return ret_obj; // Return result of proceeded method.
    }
}
