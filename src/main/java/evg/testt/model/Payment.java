package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;
import lombok.Builder;

@Entity(name = "payments")
@Builder
public @Data class Payment extends BaseModel {

    @Temporal(TemporalType.DATE)
    private Date date;

    private Float payment;

    @ManyToOne
    private Student student;

    Payment(Date date, Float payment){
        this.date = date;
        this.payment = payment;
    }
}
