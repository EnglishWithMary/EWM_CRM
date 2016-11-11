package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "admins")
public @Data class Admin extends BaseModel{

    @OneToOne
    private Person person;
}
