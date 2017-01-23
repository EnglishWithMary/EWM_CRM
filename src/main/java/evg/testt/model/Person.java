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

    @OneToOne(cascade = CascadeType.ALL)
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

    private Integer position = 0;

    private static class NullPerson extends Person implements Null {

        private NullPerson() {
            setFirstName("none");
            setLastName("none");
            setMiddleName("none");
            setAvatarURL("none");
            setBirthdayDate(new Date());
            setOrganization("none");
            setEmail(new Email("none@none.none"));
            setComments("none");
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
