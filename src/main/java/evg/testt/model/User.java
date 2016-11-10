package evg.testt.model;

import javax.persistence.*;
import net.sf.oval.constraint.Length;

@Entity(name = "users")
public class User extends BaseModel {

    @Length(min = 3, max = 20, message = "Login should be at least 3 and less than 20 symbols")
    private String login;

    @Length(min = 6, max = 20, message = "Password should be at least 3 and less than 20 symbols")
    private String password;

    @ManyToOne

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
