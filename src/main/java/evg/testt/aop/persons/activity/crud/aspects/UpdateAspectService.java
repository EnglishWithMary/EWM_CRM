package evg.testt.aop.persons.activity.crud.aspects;

import evg.testt.aop.persons.activity.aspect.service.ActivityAspectService;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by DENNNN on 27.11.2016.
 */
public class UpdateAspectService extends CRUDAspectService implements ActivityAspectService {
    @Override
    @Pointcut("execution(* evg.testt.service.impl.BaseService.update(..))")
    public void pointcut() {

    }
}
