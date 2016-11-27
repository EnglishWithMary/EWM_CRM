package evg.testt.aop.persons.activity.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.hibernate.engine.internal.JoinSequence;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by User on 27.11.2016.
 */
@Transactional
public interface ActivityAspect {

    void pointcut();

    Object doActivity(ProceedingJoinPoint pjp) throws Throwable;
}
