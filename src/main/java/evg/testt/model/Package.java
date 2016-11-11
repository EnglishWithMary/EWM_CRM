package evg.testt.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name = "packages")
public class Package extends BaseModel {

    @Temporal(TemporalType.DATE)
    private Date date_start;

    @Temporal(TemporalType.DATE)
    private Date date_stop;

    private Float cost;

    @ManyToOne
    private Student student;

    public Date getDateStart() {
        return date_start;
    }

    public void setDateStart(Date dateStart) {
        this.date_start = dateStart;
    }

    public Date getDateStop() {
        return date_stop;
    }

    public void setDateStop(Date dateStop) {
        this.date_stop = dateStop;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Student getStundent() {
        return student;
    }

    public void setStundent(Student student) {
        this.student = student;
    }
}
