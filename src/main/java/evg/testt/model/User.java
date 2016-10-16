package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "users")
public class User extends BaseModel{

    private String login;
    private String password;

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
}
