package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "notes")
public @Data class Note extends BaseModel {
    private String note;


//    @ManyToOne
////    @JoinColumn(name = "student_id")
//    private Student student;
}
