package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "leads")
public @Data class Lead extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    private Person person;

    //private PipeType pipeType;
}
