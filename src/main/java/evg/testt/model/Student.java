package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "students")

public @Data class Student extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
