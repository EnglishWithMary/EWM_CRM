package evg.testt.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity(name = "students")
public @Data class Student extends Human implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne
    private Teacher teacher;

    @ManyToOne
    private Group group;

    @OneToMany
    private List<StudentLevelHistory> studentLevelHistory;
}