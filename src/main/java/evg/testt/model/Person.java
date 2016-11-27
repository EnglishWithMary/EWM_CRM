package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    private String avatarURL;



    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    private String organization;

    @OneToOne(cascade = CascadeType.ALL)
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

    @OneToOne
    private State state;

}
