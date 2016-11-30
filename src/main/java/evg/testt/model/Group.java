package evg.testt.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "groups")
public @Data class Group extends BaseModel {

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @Column(columnDefinition = "text")
    private String comments;

    @Embedded
    private State state;
}
