package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity(name = "languages")
public @Data class Language extends BaseModel{

    private String language;

    @ManyToMany(mappedBy = "languages")
    private List<Teacher> teachers;

    public Language (){}

}
