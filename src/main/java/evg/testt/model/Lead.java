package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "leads")
public @Data class Lead extends BaseModel{

    @OneToOne
    private Person person;
}
