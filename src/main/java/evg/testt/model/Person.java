package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    private String avatarURL;

    @Embedded
    private State state = new State();

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate = new Date();

    private String organization;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

}
