package evg.testt.aop.persons.activity.aspect.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.engine.internal.JoinSequence;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 27.11.2016.
 */

public interface ActivityAspectService {

    void pointcut();

    Object doAspect(ProceedingJoinPoint pjp) throws Throwable;
}
