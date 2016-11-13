package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name = "payments")
public @Data class Payment extends BaseModel {

    @Temporal(TemporalType.DATE)
    private Date date;

    private Float payment;

    @ManyToOne
    private Student student;
}