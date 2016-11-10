package evg.testt.model;

import javax.persistence.Entity;

@Entity(name = "roles")
public class Role extends BaseModel {

    private String role;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
