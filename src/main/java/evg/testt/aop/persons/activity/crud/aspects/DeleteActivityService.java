package evg.testt.aop.persons.activity.crud.aspects;

import evg.testt.aop.persons.activity.aspect.service.ActivityAspectService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by User on 27.11.2016.
 */
@Component
@Aspect
public class DeleteActivityService extends CRUDAspectService implements ActivityAspectService {

    @Override
    @Pointcut("execution(* evg.testt.service.impl.BaseService.delete(..))")
    public void pointcut() {}
}
