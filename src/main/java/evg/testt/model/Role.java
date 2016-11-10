package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity(name = "roles")
public @Data class Role extends BaseModel {

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<User> user;

    private String role;
}
