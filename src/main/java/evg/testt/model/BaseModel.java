package evg.testt.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Builder;

@MappedSuperclass
@Builder
public @Data class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseModel baseModel = (BaseModel) o;

        return id.equals(baseModel.id);
    }
}
