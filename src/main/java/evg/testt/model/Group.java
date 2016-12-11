package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;

    @Column(columnDefinition = "text")
    private String comments;

    @Embedded
    private State state;
}
