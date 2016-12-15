package evg.testt.model;

import com.google.api.services.calendar.model.Event;
import lombok.Data;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rooms")
public @Data class Room extends BaseModel{

//    @NotNull
//    @Size(min=3, max=20)
//    @Pattern(regexp = "^[A-Za-z0-9_\\s\\-]*$")
    @NotNull
    @NotEmpty
    @Length(min = 3, max = 20, message = "Name should be between 3 and 20 chars.")
    private String name;

    @Column(name = "calendar_id")
    private String calendarId;

    @Transient
    private List<Event> events;
}
