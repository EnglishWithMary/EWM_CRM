package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;
}
