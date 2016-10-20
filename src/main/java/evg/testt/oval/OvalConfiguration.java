package evg.testt.oval;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AnnotationsConfigurer;
import net.sf.oval.integration.spring.SpringCheckInitializationListener;

import org.springframework.beans.factory.FactoryBean;

public class OvalConfiguration implements FactoryBean<Validator>{
    @Override
    public Validator getObject() throws Exception {
        AnnotationsConfigurer annotationsConfigurer = new AnnotationsConfigurer();

        annotationsConfigurer.addCheckInitializationListener(SpringCheckInitializationListener.INSTANCE);

        return new Validator(annotationsConfigurer);
    }

    @Override
    public Class<?> getObjectType() {
        return Validator.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
