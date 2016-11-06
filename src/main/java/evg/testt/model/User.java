package evg.testt.model;

import javax.persistence.*;
import java.util.Set;
import evg.testt.validators.mail.MailValidator;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;

import javax.persistence.*;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "users")
public class User extends BaseModel {

    @Length(min = 3, max = 20, message = "Wrong login.")
    private String login;

    @Length(min = 6, max = 20, message = "Incorrect password.")
    private String password;

    @MatchPattern(pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]" +
            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address.")
            private String email;

    @ManyToMany
//            (fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> role) {
        this.roles = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
