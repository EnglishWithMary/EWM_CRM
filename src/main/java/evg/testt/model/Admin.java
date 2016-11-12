package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;

@Entity(name = "admins")
public class Admin extends BaseModel{

    @Valid
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
