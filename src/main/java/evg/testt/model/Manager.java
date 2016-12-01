package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "managers")

public @Data class Manager extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
