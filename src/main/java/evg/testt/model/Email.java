package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "emails")
public @Data class Email extends BaseModel{

    private String email;

    @ManyToOne
    private Person person;
}
