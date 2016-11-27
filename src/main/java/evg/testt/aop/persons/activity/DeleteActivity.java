package evg.testt.aop.persons.activity;

import evg.testt.aop.persons.activity.service.ActivityAspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by User on 27.11.2016.
 */
@Component
@Aspect
public class DeleteActivity extends BaseAspect implements ActivityAspect{

    @Override
    @Pointcut("execution(* evg.testt.service.impl.BaseService.delete(..))")
    public void pointcut() {
    }
}
