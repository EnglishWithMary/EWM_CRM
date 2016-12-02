package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "cards")
public @Data class Card extends BaseModel{

    private String cardName = "No name.";

//    @OneToOne
//    private User user;

    @OneToOne
    private PipeType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Person> persons;
}
