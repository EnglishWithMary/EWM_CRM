package evg.testt.logger;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.slf4j.LoggerFactory;
/**
 * Created by User on 30.10.2016.
 */

/*
Class for logging system. Intercept all methods and exceptions in all classes.
 */
@Component
@Aspect
public class Logging //implements MethodInterceptor
{
//    @Pointcut("execution(* evg.testt.service.impl.DepartmentServiceImpl.*(..))" +
//            "|| execution(* evg.testt.controller.DepartmentController.*(..))")
    @Pointcut("execution(* evg.testt..*(..))")
    public void logMethods() {}

    @Around(value="logMethods()")
    public Object methodsInterceptor(ProceedingJoinPoint pjp) throws Throwable
    {
        Logger logger = LoggerFactory.getLogger(pjp.getClass());
        Object ret = null;

        logger.info("Class: " + pjp.getTarget().getClass().getName());
        logger.info("Method: " + pjp.getSignature().getName() + " starting proceed.");

        ret = pjp.proceed(); // Performs intercepted method and returns the value if it is.

        logger.info("Class: " + pjp.getTarget().getClass().getName());
        logger.info("Method: " + pjp.getSignature().getName() + " have done.");

        return ret;
    }

    @AfterThrowing(
            pointcut = "execution(* evg.testt..*(..))",
            throwing= "error")
    public void logAfterException(JoinPoint joinPoint, Throwable error)
    {
        Logger logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info("Class: " + joinPoint.getTarget().getClass().getName());
        logger.info("Method: " + joinPoint.getSignature().getName() + " have thrown exception.");
        logger.info("Exception:  ", error);
    }

}
