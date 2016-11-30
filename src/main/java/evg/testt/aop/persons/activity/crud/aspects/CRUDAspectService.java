package evg.testt.aop.persons.activity.crud.aspects;

import evg.testt.aop.persons.activity.aspect.service.ActivityAspectService;
import evg.testt.aop.persons.activity.strategy.service.StrategyAspectActivityExecutorService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by DENNNN on 27.11.2016.
 */
public abstract class CRUDAspectService implements ActivityAspectService {

    @Autowired
    StrategyAspectActivityExecutorService crudActivity;

    @Override
    @Around(value = "pointcut()")
    public Object doAspect(ProceedingJoinPoint pjp) throws Throwable {
        return crudActivity.executeAspect(pjp);
    }
}
