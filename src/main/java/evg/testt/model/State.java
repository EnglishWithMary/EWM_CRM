package evg.testt.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity(name = "states")
public @Data class State extends BaseModel {

    private String state;
}
