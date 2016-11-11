package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity(name = "teachers")
public @Data class Teacher extends BaseModel {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> personSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groupSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> studentSet;
}
