package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;
}

