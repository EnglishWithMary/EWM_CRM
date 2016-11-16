package evg.testt.model;

import javax.persistence.*;
import java.util.*;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

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
}
