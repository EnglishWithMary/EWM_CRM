package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "admins")
public @Data class Admin extends Human implements BelongsToPerson {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
