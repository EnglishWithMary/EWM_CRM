package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by DENNNN on 19.11.2016.
 */
@Entity(name = "cards")
public @Data class Card extends BaseModel{

    private String cardName = getId().toString();

    @OneToOne
    private User user;

    @OneToOne
    private PipeType type;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<CardPerson> cardPersons;
}
