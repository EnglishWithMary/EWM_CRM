package evg.testt.model;

import javax.persistence.*;
import java.util.Set;
import lombok.Data;

@Entity(name = "students")
public @Data class Student extends BaseModel {

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Teacher teacher;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Group group;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> personSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Package> packageSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> paymentSet;
}