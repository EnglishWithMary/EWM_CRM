package evg.testt.model;

import lombok.Data;
import javax.persistence.*;

@Entity(name = "emails")
public @Data class Email extends BaseModel {

    private String email;

    public Email(){}

    public Email(String email){
        this.email = email;
    }

}
