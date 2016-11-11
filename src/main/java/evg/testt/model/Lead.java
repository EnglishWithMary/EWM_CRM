package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity(name = "leads")
public @Data class Lead extends BaseModel{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lead", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> personSet;
}
