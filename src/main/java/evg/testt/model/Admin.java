package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "admins")
public @Data class Admin extends Staff implements BelongsToPerson {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user = new User(new Role("ROLE_ADMIN",1));
}
