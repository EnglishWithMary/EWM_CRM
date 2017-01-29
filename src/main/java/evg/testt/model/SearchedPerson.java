package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "searched_person")
public
@Data
class SearchedPerson extends BaseModel {

    private Integer admin_id;

    private Integer manager_id;

    private Integer teacher_id;

    private Integer student_id;

    private Integer lead_id;

    private String login;

    private String role;

    private String firstName;

    private String lastName;

    private String middleName;

    private String state;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

}
