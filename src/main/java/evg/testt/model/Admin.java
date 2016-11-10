package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "admins")
public @Data class Admin extends BaseModel{

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}
