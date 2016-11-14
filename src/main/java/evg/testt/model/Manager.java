package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "managers")

public @Data class Manager extends BaseModel {

    /*@OneToOne(fetch = FetchType.EAGER, mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private Person person;*/
}
