package evg.testt.model;

import lombok.Data;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "users")
public @Data class User extends BaseModel {
    @Size(min = 3, max = 20, message = "Login should be at least 3 and less than 20 symbols")
    private String login;

    private String password;

    @ManyToOne
    private Role role;

    public User(){}

    public User(Role role){
        this.role = role;
    }

}
