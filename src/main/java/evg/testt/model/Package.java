package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name = "packages")
public @Data class Package extends BaseModel {

    private Date date_start;

    private Date date_stop;

    private Float cost;

    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
}
