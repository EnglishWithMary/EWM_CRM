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

    @Embedded
    private State state = new State();

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Transient
    private String birthdayString;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate = new Date();

    private String organization;

    private String phone;

    private String web;

    private String address;

    private String referral;

    private String salary;

    @OneToOne(cascade = CascadeType.ALL)
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

    private Integer position = 0;

    private static class NullPerson extends Person implements Null {

        private NullPerson() {
            setFirstName("");
            setLastName("");
            setMiddleName("");
            setAvatarURL("");
            setBirthdayDate(new Date());
            setOrganization("");
            setEmail(new Email(""));
            setComments("");
        }

        @Override
        public String toString() {
            return "NullPerson";
        }
    }

    public static final Person NULL = new NullPerson();

//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
//    List<Activity> activities;
}
