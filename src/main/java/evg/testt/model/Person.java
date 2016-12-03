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

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;

    @Embedded
    private State state;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Role role;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    private String organization;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personActivities")
//    List<Activity> activities;
}
