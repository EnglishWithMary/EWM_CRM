package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "teachers")

public @Data class Teacher extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
