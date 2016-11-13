package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "phones")
public @Data class Phone extends BaseModel{

    private String phone;

    @ManyToOne()
    private Person person;
}
