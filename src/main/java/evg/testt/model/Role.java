package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity(name = "roles")
public class Role extends BaseModel {

    /**
     * TODO: create table that consists of four roles:
     * - ROLE_ADMIN
     * - ROLE_MANAGER
     * - ROLE_TEACHER
     * - ROLE_USER
     *
     * */

    @ManyToMany(mappedBy = "roles")
//    @JoinColumn(name = "user_id")
//    @JoinTable(name = "users_roles")
    private Set<User> users;

    private String role;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
