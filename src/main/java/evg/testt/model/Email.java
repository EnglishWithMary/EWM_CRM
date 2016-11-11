package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Builder;

@Entity(name = "emails")
@Builder
public @Data class Email extends BaseModel{

    private String email;

    @ManyToOne
    private Person person;
}
