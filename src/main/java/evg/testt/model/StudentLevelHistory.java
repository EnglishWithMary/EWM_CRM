package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

public @Data class StudentLevelHistory extends BaseModel {

    @Temporal(TemporalType.DATE)
    private Date checkPointDate;

    @ManyToOne
    private String grammarLevel;

}
