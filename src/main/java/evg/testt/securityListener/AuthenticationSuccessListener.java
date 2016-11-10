package evg.testt.securityListener;

import evg.testt.model.User;
import evg.testt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

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

    @Autowired
    UserService us;

    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent interactiveAuthenticationSuccessEvent) {

        UserDetails userDetails = (UserDetails)interactiveAuthenticationSuccessEvent.getAuthentication().getPrincipal();
        String login = userDetails.getUsername();

        User u = us.findByUserLogin(login);

        if(u.getIsFirstLogin().equals("true")) {
            smm.setTo(u.getEmail());
            smm.setText(msg);
            jms.send(smm);

            u.setIsFirstLogin("false");
            try {
                us.update(u);
            }catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
}
