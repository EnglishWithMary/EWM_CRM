package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "managers")

public @Data class Manager extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
