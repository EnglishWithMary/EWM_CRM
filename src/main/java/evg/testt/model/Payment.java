package evg.testt.model;

import javax.persistence.*;
import java.util.Date;
import lombok.Data;

@Entity(name = "payments")
public @Data class Payment extends BaseModel {

    private Date date;

    private Float payment;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Student student;

    Payment(Date date, Float payment){
        this.date = date;
        this.payment = payment;
    }
}
