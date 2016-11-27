package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Created by User on 27.11.2016.
 */
@Entity(name = "personActivities")
public @Data class Activity extends BaseModel{

    private String activity;

    @ManyToOne
    private Person person;
}
