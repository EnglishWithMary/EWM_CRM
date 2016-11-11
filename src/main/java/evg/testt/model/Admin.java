package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import java.util.Set;

@Entity(name = "admins")
public @Data class Admin extends BaseModel{

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Person> personSet;
}
