package evg.testt.model;

import evg.testt.validators.mail.MailValidator;

import javax.persistence.*;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "users")
public class User extends BaseModel{

    @Column(unique = true)
    private String login;
    private String password;

    @MailValidator
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
