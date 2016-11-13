package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name = "events")
public @Data class Event extends BaseModel {

    private String name;

    private String comment;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String type;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Group group;
}