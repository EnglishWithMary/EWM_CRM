package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.Builder;

@Entity(name = "packages")
@Builder
public @Data class Package extends BaseModel {

    @Temporal(TemporalType.DATE)
    private Date date_start;

    @Temporal(TemporalType.DATE)
    private Date date_stop;

    private Float cost;

    @ManyToOne
    private Student student;
}
