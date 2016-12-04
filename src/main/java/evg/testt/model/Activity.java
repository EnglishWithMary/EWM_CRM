package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "activities")
public @Data class Activity extends BaseModel{

    private String activity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

//    @ManyToOne
//    private Person person;
}
