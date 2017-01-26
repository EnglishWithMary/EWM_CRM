package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "notes")
public @Data class Note extends BaseModel {
    private String note;


    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
