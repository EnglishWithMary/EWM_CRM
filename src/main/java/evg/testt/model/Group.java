package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
