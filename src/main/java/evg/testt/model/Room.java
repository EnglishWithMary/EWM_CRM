package evg.testt.model;

import com.google.api.services.calendar.model.Event;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "rooms")
public @Data class Room extends BaseModel{

    @NotNull
    @Size(min=3, max=20)
    @Pattern(regexp = "^[A-Za-z0-9_\\s\\-]*$")
    private String name;

    @Column(name = "calendar_id")
    private String calendarId;

    @Transient
    private List<Event> events;
}
