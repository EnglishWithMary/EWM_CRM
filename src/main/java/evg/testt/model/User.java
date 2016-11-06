package evg.testt.model;

import evg.testt.validators.mail.MailValidator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;

import javax.persistence.*;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "users")
public class User extends BaseModel{

    @Length(min = 3, max = 20, message = "Wrong login.")
    private String login;

    @Length(min = 6, max = 20, message = "Incorrect password.")
    private String password;

    @MatchPattern(pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]" +
            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address.")
            private String email;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    private Role role;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
