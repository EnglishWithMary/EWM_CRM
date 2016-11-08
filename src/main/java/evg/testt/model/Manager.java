package evg.testt.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "managers")
public class Manager extends BaseModel {

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="persons_id")
    private Person person;


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
