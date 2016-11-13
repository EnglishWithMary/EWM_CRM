package evg.testt.dto;

import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;

/**
 * Created by leonid on 13.11.16.
 */
public class TeacherDTO {


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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

}
