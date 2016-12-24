package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "pipetypes")
public @Data class PipeType extends BaseModel{

    private String type;
}
