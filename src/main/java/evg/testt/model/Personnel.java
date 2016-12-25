package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "personnel")
public
@Data
class Personnel extends BaseModel {

    private String login;

    private String role;

    private String firstName;

    private String lastName;

    private String middleName;

    private String avatarURL;

    private String state;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    private String organization;

    @Column(name = "email_id")
    public Integer emailID;

    @Column(columnDefinition = "text")
    private String comments;
}
