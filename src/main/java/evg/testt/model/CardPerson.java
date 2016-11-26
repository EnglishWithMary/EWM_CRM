package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by DENNNN on 19.11.2016.
 */
@Entity(name = "card_persons")
public @Data class CardPerson extends BaseModel{

    @ManyToOne
    @JoinColumn(name = "cards_id")
    Card card;

    @OneToOne
    Person person;
}
