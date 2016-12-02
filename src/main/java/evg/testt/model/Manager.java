package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "managers")

public @Data class Manager extends Human {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
