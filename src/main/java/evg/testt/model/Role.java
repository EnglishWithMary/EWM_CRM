package evg.testt.model;

import javax.persistence.*;
import lombok.Data;

@Entity(name = "roles")
public @Data class Role extends BaseModel {

    private String role;
}
