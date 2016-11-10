package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name = "events")
public @Data class Event extends BaseModel {

    private String name;

    private String comment;

    private Date date;

    private String type;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Event(){ }

    public Event(String name, String comment, Date date, String type){
        this.name = name;
        this.comment = comment;
        this.date = date;
        this.name = type;
    }
}
