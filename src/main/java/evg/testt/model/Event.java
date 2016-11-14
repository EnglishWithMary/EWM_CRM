package evg.testt.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity(name = "events")
public @Data class Event extends BaseModel {

}
