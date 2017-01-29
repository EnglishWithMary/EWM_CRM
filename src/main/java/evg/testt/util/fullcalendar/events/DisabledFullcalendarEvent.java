package evg.testt.util.fullcalendar.events;

import evg.testt.util.fullcalendar.events.FullcalendarEvent;
import lombok.Data;

public @Data class DisabledFullcalendarEvent extends FullcalendarEvent implements IDisabledFullcalendarEvent {

    private Boolean overlap;

    private String rendering;

}
