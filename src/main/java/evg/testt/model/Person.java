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

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private User user;

    /*@OneToOne(cascade = CascadeType.ALL)
    private User user;
*/
//    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
//    private User user;

//    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Manager manager;
}
