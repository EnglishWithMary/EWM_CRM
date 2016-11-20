package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;
}
