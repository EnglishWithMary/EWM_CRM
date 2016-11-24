package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DENNNN on 19.11.2016.
 */
@Entity(name = "cards")
public @Data class Card extends BaseModel{

    @OneToOne
    User user;

    @OneToOne
    PipeType type;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<CardPerson> cardPersons;
}
