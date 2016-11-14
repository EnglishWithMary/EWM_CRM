package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import net.sf.oval.constraint.Length;

@Entity(name = "users")
public @Data class User extends BaseModel {

    @Length(min = 3, max = 20, message = "Login should be at least 3 and less than 20 symbols")
    private String login;

    @Length(min = 6, max = 20, message = "Password should be at least 3 and less than 20 symbols")
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;
}
