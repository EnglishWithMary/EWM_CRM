package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Builder;

@Entity(name = "phones")
@Builder
public @Data class Phone extends BaseModel{

    private String phone;

    @ManyToOne()
    private Person person;
}
