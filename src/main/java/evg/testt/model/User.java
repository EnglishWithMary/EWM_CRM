package evg.testt.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseModel {

    private String login;
    private String password;

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
}
