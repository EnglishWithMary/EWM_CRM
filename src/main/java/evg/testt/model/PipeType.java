package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;

/**
 * Created by DENNNN on 19.11.2016.
 */
@Entity(name = "pipetypes")
public @Data class PipeType extends BaseModel{

    private String type;
}
