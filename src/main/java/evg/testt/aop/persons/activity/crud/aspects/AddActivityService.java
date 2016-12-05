package evg.testt.aop.persons.activity.crud.aspects;

import evg.testt.aop.persons.activity.aspect.service.ActivityAspectService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AddActivityService extends CRUDAspectService implements ActivityAspectService {

    @Override
    @Pointcut("execution(* evg.testt.service.impl.BaseService.insert(..))")
    public void pointcut() {}

}
