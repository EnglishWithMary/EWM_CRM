package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    private String organization;

    @OneToOne(cascade = CascadeType.ALL)
    Email email;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private State state;

}
