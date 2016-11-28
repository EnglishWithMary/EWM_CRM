package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity (name = "persons")
public @Data class Person extends BaseModel{

    private String firstName;

    private String lastName;

    private String middleName;

    private String avatarURL;

    private String state;

    @Temporal(TemporalType.DATE)
    private Date birthdayDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;

    @Column(columnDefinition = "text")
    private String organization;

    @OneToOne(cascade = CascadeType.ALL)
    Email email;

    @Column(columnDefinition = "text")
    private String comments;

    public void setBirthdayDate(String dateS) {
        SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            d = sdtf.parse(dateS);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        birthdayDate=d;
    }

    public String getBirthdayDate() {
        SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd");

        String stringDate;

        stringDate = sdtf.format(birthdayDate);

        return stringDate;
    }

}
