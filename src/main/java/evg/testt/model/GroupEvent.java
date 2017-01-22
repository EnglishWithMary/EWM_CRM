package evg.testt.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "group_events")
public
@Data
class GroupEvent extends BaseModel {

//    @Column(name = "room_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;

    @Column(name = "group_id")
    private Integer groupId;

    private String title;

    @DateTimeFormat
    @Column(name = "start_date")
    private Date startDate;

    @DateTimeFormat
    @Column(name = "end_date")
    private Date endDate;

    private String description;

    private Date created;

    private Date updated;

    @PrePersist
    private void create(){
        this.setCreated(new Date());
        this.update();
    }

    @PreUpdate
    private void update(){
        this.setUpdated(new Date());
    }

        /* All Day option is not necessary */
}
