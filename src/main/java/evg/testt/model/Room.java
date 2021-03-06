package evg.testt.model;

import com.google.api.services.calendar.model.Event;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "rooms")
public @Data class Room extends BaseModel{

    @NotNull
    @NotEmpty(message = "Should be not empty")
    @Size(min = 3, max = 20, message = "Name should be between 3 and 20 chars.")
    private String name;

    private String color;

//    @Column(name = "calendar_id")
//    private String calendarId;
//
    @Transient
    private List<Event> events;
}
