package evg.testt.model;

import lombok.Data;
import javax.persistence.OneToOne;

public @Data abstract class Human extends BaseModel{

    @OneToOne
    Person person;

    public Person getPerson(){
        return (person==null)?Person.NULL:person;
    }

}
