package evg.testt.model;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity(name = "teachers")

public @Data class Teacher extends RegisteredUser implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user = new User(new Role("ROLE_TEACHER",3));

    @Column(name = "level")
    @Enumerated(EnumType.ORDINAL)
    private TeacherLevelEnum level;

}
