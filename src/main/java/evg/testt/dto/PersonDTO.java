package evg.testt.dto;

import lombok.Data;
import net.sf.oval.constraint.EqualToField;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;

import javax.persistence.Transient;
import java.util.List;

public @Data class PersonDTO {

    @Length(min = 3, max = 20, message = "Login should be between 3 and 20 chars.")
    private String login;

    @Length(min = 6, max = 20, message = "Password should be between 6 and 20 chars.")
    private String password;

    @Length(min = 6, max = 20, message = "Password should be between 6 and 20 chars.")
    @EqualToField(value = "password", message = "Passwords don't match")
    @Transient
    private String confirmPassword;

    @MatchPattern(pattern = "[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-zA-Z0-9]" +
            "(?:[a-zA-Z0-9-]*[a-zA-Z0-9])?\\.)+[a-zA-Z0-9](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?", message = "Invalid email address.")
    private String email;

    @Length(min = 3, max = 20, message = "First Name should be between 3 and 20 chars.")
    private String firstName;

    @Length(min = 3, max = 20, message = "Last Name should be between 3 and 20 chars.")
    private String lastName;

    @Length(min = 3, max = 20, message = "Middle Name should be between 3 and 20 chars.")
    private String middleName;

    private String comments;

    private String organization;

    private String birthdayDate;

    private String avatarURL;

    private Integer cardId;

    private List<String>languages;
}
