package evg.testt.model;

import javax.persistence.*;
import java.util.Set;
import lombok.Data;
import lombok.Builder;

@Entity(name = "students")
@Builder
public @Data class Student extends BaseModel {

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Group group;

    @OneToOne
    private Person person;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Package> packageSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> paymentSet;
}