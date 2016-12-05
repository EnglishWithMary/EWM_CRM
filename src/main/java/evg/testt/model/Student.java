package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "students")

public @Data class Student extends Human implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne
    private Teacher teacher;
}
