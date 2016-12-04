package evg.testt.dto;

import evg.testt.model.*;
import lombok.Data;
import net.sf.oval.constraint.EqualToField;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.MatchPattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Transient;
import java.util.Set;

public @Data class PersonDTO {

    @Length(min = 3, max = 20, message = "Login should be between 6 and 20 chars.")
    private String login;

    @Length(min = 6, max = 20, message = "Password should be between 6 and 20 chars.")
    private String password;

    @Length(min = 6, max = 20, message = "Incorrect password.")
    @EqualToField(value = "password", message = "Passwords don't match")
    @Transient
    private String confirmPassword;

    @MatchPattern(pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9]" +
            "(?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email address.")
    private String email;

    @Length(min = 3, max = 20, message = "First Name should be between 3 and 20 chars.")
    private String firstName;

    @Length(min = 3, max = 20, message = "Last Name should be between 3 and 20 chars.")
    private String lastName;

    @Length(min = 3, max = 20, message = "Middle Name should be between 3 and 20 chars.")
    private String middleName;

    private String comments;

    private Integer cardId;

    public Person getFulledPerson()
    {
        return new Person()
        {
            {
                this.setFirstName(firstName);
                this.setLastName(lastName);
                this.setMiddleName(middleName);
                this.setComments(comments);
                Email newEmail = new Email();
                newEmail.setEmail(email);
                this.setEmail(newEmail);
                State state = new State();
                state.setState(StateType.STATE_ACTIVE.name());
                this.setState(state);
            }
        };
    }

    public User getFulledUser()
    {
        return new User(){
            {
                this.setLogin(login);
                this.setPassword(password);
            }
        };
    }

    public User getFulledUserWithRoleAndCryptedPassword(Role role, BCryptPasswordEncoder passwordEncoder)
    {
        return new User(){
            {
                this.setRole(role);
                this.setLogin(login);
                this.setPassword(passwordEncoder.encode(password));
            }
        };
    }

    public Admin getAdmin(Role role, BCryptPasswordEncoder passwordEncoder)
    {
        Admin newAdmin = new Admin();
        newAdmin.setPerson(getFulledPerson());
        newAdmin.setUser(getFulledUserWithRoleAndCryptedPassword(role, passwordEncoder));

        return newAdmin;
    }

    public Manager getManager(Role role, BCryptPasswordEncoder passwordEncoder)
    {
        Manager newManager = new Manager();
        newManager.setPerson(getFulledPerson());
        newManager.setUser(getFulledUserWithRoleAndCryptedPassword(role, passwordEncoder));

        return newManager;
    }

    public Teacher getTeacher(Role role, BCryptPasswordEncoder passwordEncoder)
    {
        Teacher newTeacher = new Teacher();
        newTeacher.setPerson(getFulledPerson());
        newTeacher.setUser(getFulledUserWithRoleAndCryptedPassword(role, passwordEncoder));

        return newTeacher;
    }

    public Student getStudent(Role role, BCryptPasswordEncoder passwordEncoder)
    {
        Student newStudent = new Student();
        newStudent.setPerson(getFulledPerson());
        newStudent.setUser(getFulledUserWithRoleAndCryptedPassword(role, passwordEncoder));

        return newStudent;
    }

    public Lead getLead()
    {
        Lead newLead = new Lead();
        newLead.setPerson(getFulledPerson());
        return newLead;
    }
}
