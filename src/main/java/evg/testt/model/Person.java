package evg.testt.model;

import javax.persistence.*;
import java.util.*;
import lombok.Data;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    private Date birthdayDate;

    private String organization;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Email> emailSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phoneSet;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Event> eventSet;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Admin admin;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Manager manager;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Teacher teacher;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Student student;

    public Person(){ }

    public Person(String firstName, String lastName, String middleName, Date birthdayDate, String organization) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthdayDate = birthdayDate;
        this.organization = organization;
    }
}
