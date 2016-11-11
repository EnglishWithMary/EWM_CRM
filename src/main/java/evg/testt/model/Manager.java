package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "managers")
public @Data class Manager extends BaseModel {

    @OneToOne
    private Person person;
}
