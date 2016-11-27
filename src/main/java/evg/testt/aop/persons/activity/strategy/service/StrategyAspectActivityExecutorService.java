package evg.testt.aop.persons.activity.strategy.service;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by DENNNN on 27.11.2016.
 */
public interface StrategyAspectActivityExecutorService {
    Object executeAspect(ProceedingJoinPoint pjp) throws Throwable;
}
