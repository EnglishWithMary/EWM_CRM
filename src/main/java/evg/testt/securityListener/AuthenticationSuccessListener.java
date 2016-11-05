package evg.testt.securityListener;

import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Created by DENNNN on 05.11.2016.
 */
@Component
public class AuthenticationSuccessListener implements ApplicationListener<InteractiveAuthenticationSuccessEvent>{
    @Override
    public void onApplicationEvent(InteractiveAuthenticationSuccessEvent interactiveAuthenticationSuccessEvent) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!LOOOOOGEF!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!LOOOOOGEF!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!LOOOOOGEF!!!!!!!!!!!!!!!!!!");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!LOOOOOGEF!!!!!!!!!!!!!!!!!!");

        UserDetails s = (UserDetails) interactiveAuthenticationSuccessEvent.getAuthentication().getPrincipal();
        System.out.println(s.getUsername());
        System.out.println(s.getPassword());
        System.out.println(interactiveAuthenticationSuccessEvent.getAuthentication().getCredentials());
    }
}
