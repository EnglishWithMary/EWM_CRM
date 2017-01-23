package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    private String language;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group")
    private List<Student> students;

    @Column(columnDefinition = "text")
    private String comments;

    @Embedded
    private State state;

    @Override
    public String toString() {
        return "".toString();
    }
}
