package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "managers")
public @Data class Manager extends Staff implements BelongsToPerson{

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user = new User(new Role("ROLE_MANAGER",2));
}
