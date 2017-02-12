package evg.testt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "languages")
public @Data class Language extends BaseModel{

    private String language;

    @ManyToMany(mappedBy = "languages", fetch = FetchType.EAGER)
    private List<Teacher> teachers;

}
