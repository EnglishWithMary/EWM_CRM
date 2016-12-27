package evg.testt.model;

import lombok.Data;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Transactional
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
}