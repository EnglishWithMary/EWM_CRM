package evg.testt.securityListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by DENNNN on 05.11.2016.
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent>{

    @Autowired
    private JavaMailSender jms;

    @Autowired
    SimpleMailMessage smm;

    @Resource(name = "messageForMail")
    String msg;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent interactiveAuthenticationSuccessEvent) {
        smm.setTo("testspringmail@mailinator.com");
        smm.setText(msg);
        jms.send(smm);

    }
}
