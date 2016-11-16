package evg.testt.dto;

import evg.testt.model.Email;
import lombok.Data;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import java.util.Set;

public @Data class PersonDTO {

    @Length(min = 3, max = 20, message = "Wrong login.")
    private String login;

    @Length(min = 6, max = 20, message = "Incorrect password.")
    private String password;

    @MatchPattern(pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]" +
            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address.")
    private String email;

    @Length(min = 3, max = 20, message = "Wrong name.")
    private String firstName;

    @Length(min = 3, max = 20, message = "Wrong last name.")
    private String lastName;

    @Length(min = 3, max = 20, message = "Wrong middle name.")
    private String middleName;
}
