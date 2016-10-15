package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;

/**
 * Created by clay on 05.10.16.
 */

@Entity(name = "roles")
public class Role extends BaseModel {

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String role;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
