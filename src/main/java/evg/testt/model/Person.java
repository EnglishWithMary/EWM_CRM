package evg.testt.model;

import javax.persistence.*;
import java.util.*;
import lombok.Data;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    private String organization;
}
