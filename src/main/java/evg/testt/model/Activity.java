package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 27.11.2016.
 */
@Entity(name = "personActivities")
public @Data class Activity extends BaseModel{

    private String activity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToOne
    private Person person;
}
