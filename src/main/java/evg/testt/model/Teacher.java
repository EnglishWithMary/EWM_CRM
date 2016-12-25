package evg.testt.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "teachers")
public @Data class Teacher extends RegisteredUser implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user = new User(new Role("ROLE_TEACHER",3));

    @ManyToMany()
    @JoinTable(name="teacher_languages", joinColumns=@JoinColumn(name="teacher_id"),
            inverseJoinColumns = @JoinColumn(name="language_id"))
    private List<Language> languages;

    public Teacher (){}
}
