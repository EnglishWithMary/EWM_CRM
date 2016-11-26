package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "states")
public @Data class StateDelete extends BaseModel{
        private String stateDelete;

}

