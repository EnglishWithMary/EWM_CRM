package evg.testt.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
public @Data class Student extends RegisteredUser implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user = new User(new Role("ROLE_STUDENT",4));

    @OneToOne
    private Teacher teacher;

    @ManyToOne
    private Group group;

    @OneToMany
    private List<StudentLevelHistory> studentLevelHistory;
}