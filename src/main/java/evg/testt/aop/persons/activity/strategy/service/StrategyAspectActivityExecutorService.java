package evg.testt.aop.persons.activity.strategy.service;

import org.aspectj.lang.ProceedingJoinPoint;

public interface StrategyAspectActivityExecutorService {
    Object executeAspect(ProceedingJoinPoint pjp) throws Throwable;
}
