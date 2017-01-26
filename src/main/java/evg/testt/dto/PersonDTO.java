package evg.testt.dto;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.persistence.Transient;
import java.sql.Date;

@FieldEquals( field="password", equalsTo="confirmPassword" )
public @Data class PersonDTO {


    @Size(min = 3, max = 20, message = "Login should be between 6 and 20 chars.")
    private String login;

    @Size(min = 6, max = 20, message = "Password should be between 6 and 20 chars.")
    private String password;

    @Size(min = 6, max = 20, message = "Incorrect password.")
    @Transient
    private String confirmPassword;

    @Pattern(regexp = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9]" +
            "(?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?", message = "Invalid email address.")
    private String email;

    @Size(min = 3, max = 20, message = "First Name should be between 3 and 20 chars.")
    private String firstName;

    @Size(min = 3, max = 20, message = "Last Name should be between 3 and 20 chars.")
    private String lastName;

    @Size(max = 20, message = "Middle Name should less than 20 chars.")
    private String middleName;

    private String comments;

    private String organization;

    private String birthdayString;

    private Date birthdayDate;

    protected String avatarURL;

    protected Integer cardId;
}
