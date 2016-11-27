package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "admins")

public @Data class Admin extends BaseModel implements BelongsToPerson {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
